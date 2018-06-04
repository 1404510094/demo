package com.example.demo.controller;

import com.example.demo.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:chengbg
 * @date:2018/6/4
 */
@RestController
public class LoginController {

    @RequestMapping("/login")
    public String login(User user){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken();
        return null;
    }
}
