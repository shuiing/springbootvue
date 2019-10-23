package com.shui.sqlite.controller;

import com.shui.sqlite.data.User;
import com.shui.sqlite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/name")
    public User getUser(String id){
        return  userService.getUser(id);
    }
}
