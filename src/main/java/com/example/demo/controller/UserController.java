package com.example.demo.controller;

import com.example.demo.common.result.Result;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result deleteByPrimaryKey(Integer id){
        Result result = new Result();

        boolean success = userService.deleteByPrimaryKey(id);
        result.setData(success);
        return result;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result insert(@Valid User record) {
        Result result = new Result();

        boolean success = userService.insert(record);
        return result;
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public Result selectByPrimaryKey(Integer id) {
        Result result = new Result();

        User user = userService.selectByPrimaryKey(id);
        result.setData(user);
        return result;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result selectAll() {
        Result result = new Result();
        List<User> users = userService.selectAll();
        result.setData(users);
        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result updateByPrimaryKey(User record) {
        Result result = new Result();

        boolean success = userService.updateByPrimaryKey(record);
        return result;
    }
}
