package com.example.demo.service;

import com.example.demo.domain.User;

import java.util.List;

public interface UserService {
    boolean deleteByPrimaryKey(Integer id);

    boolean insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    boolean updateByPrimaryKey(User record);

    User findByUsername(String username);
}
