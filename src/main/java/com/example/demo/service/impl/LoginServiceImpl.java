package com.example.demo.service.impl;

import com.example.demo.common.enums.ResultEnum;
import com.example.demo.common.exception.BusinessException;
import com.example.demo.dao.UserMapper;
import com.example.demo.domain.User;
import com.example.demo.handler.MyExceptionHandler;
import com.example.demo.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:chengbg
 * @date:2018/6/4
 */
@Service
public class LoginServiceImpl implements LoginService{

    private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(User user) {
        //获取用户输入的用户名和密码
        String username = user.getUsername();
        String password = user.getPassword();
        //获取当前主体
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            //进行登录认证
            subject.login(token);
        }catch (UnknownAccountException e){
            //账号不存在
            throw new BusinessException(ResultEnum.UNKONW_USER);
        } catch (IncorrectCredentialsException e){
            //密码错误
            throw new BusinessException(ResultEnum.UNKONW_USER);
        }
        //判断是否认证成功
        boolean authenticated = subject.isAuthenticated();

        return authenticated;
    }
}
