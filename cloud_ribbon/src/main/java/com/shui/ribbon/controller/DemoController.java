package com.shui.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/ribbon")
    public String dc(){
        return restTemplate.getForObject("http://cloud-client/dc",String.class);
    }
}
