package com.springbootdemo.service;

import com.springbootdemo.bean.User;
import com.springbootdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    UserMapper userMapper;
    public User selectUser(int id) {
        return userMapper.selectUser(id);
    }
}
