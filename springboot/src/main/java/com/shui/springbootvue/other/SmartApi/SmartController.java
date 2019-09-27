package com.shui.springbootvue.other.SmartApi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/smart")
public class SmartController {

    @PostMapping
    public User create(User user) {
        return user;
    }


    @GetMapping
    public User getName(String name) {
        return new User();
    }


    @PutMapping
    public String update(String name) {
        return name;
    }


    @DeleteMapping
    public String delete(String name) {
        return name;
    }

}
