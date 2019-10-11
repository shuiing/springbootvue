package com.shui.feign.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("config-client")
public interface DemoFeginClient {

    @GetMapping("/dc")
    String consumer();

    @GetMapping("/fegintest")
    String fegin();
}
