package com.example.demo.controller.impl;

import com.example.demo.controller.UserController;
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
public class UserControllerImpl implements UserController{



    @Autowired
    private UserService userService;

    @Override
    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteByPrimaryKey(Integer id) {
        userService.deleteByPrimaryKey(id);
        return "";
    }

    @Override
    @Transactional
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String insert(@Valid User record) {
        boolean success = userService.insert(record);
        return success == true ? "成功" : "失败";
    }

    @Override
    public String selectByPrimaryKey(Integer id) {
        userService.selectByPrimaryKey(id);
        return null;
    }

    @Override
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> selectAll() {
        return userService.selectAll();
    }

    @Override
    @Transactional
    public String updateByPrimaryKey(User record) {
        userService.updateByPrimaryKey(record);
        return "";
    }
}
