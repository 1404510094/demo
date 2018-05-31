package com.example.demo.controller.impl;

import com.example.demo.controller.UserController;
import com.example.demo.domain.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController{

    @Autowired
    private UserService userService;

    @Override
    public String deleteByPrimaryKey(Integer id) {
        return "";
    }

    @Override
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String insert(User record) {
        boolean success = userService.insert(record);
        return success == true ? "成功" : "失败";
    }

    @Override
    public String selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
    public String updateByPrimaryKey(User record) {
        return "";
    }
}
