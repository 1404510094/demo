package com.example.demo.controller;

import com.example.demo.domain.User;
import org.junit.Test;

public class UserControllerImplTest {

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("cbg");
        user.setPassword("123456");
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void selectAll() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}