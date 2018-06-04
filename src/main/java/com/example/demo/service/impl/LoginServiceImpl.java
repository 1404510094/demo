package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * @author:chengbg
 * @date:2018/6/4
 */
@Service
public class LoginServiceImpl implements LoginService{
    @Override
    public boolean login(User user) {
        //获取用户输入的用户名和密码
        String username = user.getUsername();
        String password = user.getPassword();
        //获取当前主体
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //进行登录认证
        subject.login(token);
        //判断是否认证成功
        boolean authenticated = subject.isAuthenticated();

        return authenticated;
    }
}
