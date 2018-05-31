package com.example.demo.controller;

import com.example.demo.domain.entity.User;

import java.util.List;

public interface UserController{

    String deleteByPrimaryKey(Integer id);

    String insert(User record);

    String selectByPrimaryKey(Integer id);

    List<User> selectAll();

    String updateByPrimaryKey(User record);
}
