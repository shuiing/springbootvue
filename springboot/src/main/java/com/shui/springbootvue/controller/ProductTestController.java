package com.shui.springbootvue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductTestController {
    @RequestMapping("/info")
    @ResponseBody
    public String productInfo(){
        return " some product info ";
    }

    @RequestMapping("/home")
    @ResponseBody
    public String productHome(){
        return " product home ";
    }
}