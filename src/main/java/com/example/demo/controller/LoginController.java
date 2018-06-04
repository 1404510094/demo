package com.example.demo.controller;

import com.example.demo.common.result.Result;
import com.example.demo.domain.User;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author:chengbg
 * @date:2018/6/4
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@Valid User user){
        Result result = new Result();
        boolean login = loginService.login(user);
        result.setData(login);
        return result;
    }
}
