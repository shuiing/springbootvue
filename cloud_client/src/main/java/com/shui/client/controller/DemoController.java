package com.shui.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 */

@RestController
public class DemoController {

    @Autowired
    DiscoveryClient discoveryClient;

    //获取服务名
    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

    //用于其他服务调用测试
    @GetMapping("/fegintest")
    public String fegintest() {
        return "调用cloud-client成功";
    }

}
