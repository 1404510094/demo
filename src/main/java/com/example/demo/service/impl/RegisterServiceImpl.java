package com.example.demo.service.impl;

import com.example.demo.common.enums.ResultEnum;
import com.example.demo.common.exception.BusinessException;
import com.example.demo.common.utils.Util;
import com.example.demo.dao.UserMapper;
import com.example.demo.domain.User;
import com.example.demo.handler.MyExceptionHandler;
import com.example.demo.service.RegisterService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;

/**
 * @author:chengbg
 * @date:2018/6/5
 */
@Service
public class RegisterServiceImpl implements RegisterService{

    private static final String ALGORITHMNAME = "md5";
    private static final int HASHITERATIONS = 100;

    private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public boolean register(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        //根据用户名从数据库获取用户
        User dbUser = userMapper.findByUsername(username);
        //用户已存在
        if(dbUser != null){
            throw new BusinessException(ResultEnum.ALREADY_USER);
        }

        //获取随机盐
        String salt = null;
        try {
            salt = Util.getSalt() + username;
        } catch (NoSuchAlgorithmException e) {
            throw new BusinessException(ResultEnum.SYSTEM_ERROR);
        }

        //对明文密码加密
        SimpleHash hash = new SimpleHash(ALGORITHMNAME, password, salt, HASHITERATIONS);
        String hashedPassword = hash.toHex();

        user.setPassword(hashedPassword);
        user.setSalt(salt);
        user.setState(1);

        int success = userMapper.insert(user);

        return success > 0;
    }

}
