package com.shui.cloudhystrix.controller;

import com.shui.cloudhystrix.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    ConsumerService consumerService;

    @GetMapping("/consumer")
    public String dc() {
        return consumerService.consumer();
    }

}
