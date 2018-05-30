package com.example.demo.controller.api;

import com.example.demo.domain.entity.User;

import java.util.List;

public interface UserController{

    int addUser();

    int deleteUser();

    int updateUser();

    User selectUserById();

    List<User> selectAll();
}
