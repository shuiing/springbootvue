package com.shui.sqlite.service;

import com.shui.sqlite.data.User;
import com.shui.sqlite.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUser(String id){
        return userMapper.findUser(id);
    }

}
