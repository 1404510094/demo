package com.example.demo.controller;

import com.example.demo.common.result.Result;
import com.example.demo.domain.User;
import com.example.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author:chengbg
 * @date:2018/6/5
 */
@RestController
@RequestMapping(value = "/user")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result login(@Valid User user) {
        Result result = new Result();
        boolean success = registerService.register(user);
        result.setData(success);
        return result;
    }
}
