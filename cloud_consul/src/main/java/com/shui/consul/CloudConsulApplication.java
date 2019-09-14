package com.shui.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class CloudConsulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsulApplication.class, args);
    }

}
