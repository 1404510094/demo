package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public UserServiceImpl() {
    }

    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean insert(User record) {
        return userMapper.insert(record) > 0;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public boolean updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record) > 0;
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
