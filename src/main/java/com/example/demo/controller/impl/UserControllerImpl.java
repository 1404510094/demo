package com.example.demo.controller.impl;

import com.example.demo.common.result.Result;
import com.example.demo.domain.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserControllerImpl{

    @Autowired
    private UserService userService;

    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result deleteByPrimaryKey(Integer id){
        Result result = new Result();

        boolean success = userService.deleteByPrimaryKey(id);
        result.setCode(1);
        result.setMessage("");
        result.setData(success);
        return result;
    }

    @Transactional
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result insert(@Valid User record) {
        Result result = new Result();

        boolean success = userService.insert(record);
        String message = success == true ? "成功" : "失败";
        result.setCode(1);
        result.setMessage(message);
        result.setData(null);
        return result;
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public Result selectByPrimaryKey(Integer id) {
        System.out.print(id);
        Result result = new Result();

        User user = userService.selectByPrimaryKey(id);
        result.setCode(1);
        result.setMessage("");
        result.setData(user);
        return null;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result selectAll() {
        Result result = new Result();
        List<User> users = userService.selectAll();
        result.setCode(1);
        result.setMessage("");
        result.setData(users);
        return result;
    }

    @Transactional
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result updateByPrimaryKey(User record) {
        Result result = new Result();

        boolean success = userService.updateByPrimaryKey(record);
        result.setCode(1);
        result.setMessage("");
        result.setData(null);
        return result;
    }
}
