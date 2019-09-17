package com.shui.feign.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DemoController {


    @Autowired
    DemoFeginClient dcClient;

    /**
     * 测试调用其他服务
     */
    @GetMapping("/consumer")
    public String dc() {
        return dcClient.consumer();
    }

    /**
     * 测试调用其他服务
     */
    @GetMapping("/demoFegin")
    public String demoFegin() {
        return dcClient.fegin();
    }


    /**
     * 接收文件
     */
    @PostMapping(value = "/getFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String getFile(@RequestPart MultipartFile file) {
        return file.getOriginalFilename();
    }

    //用于其他服务调用测试
    @GetMapping("/testfegin")
    public String fegintest() {
        return "调用cloud-feign成功";
    }

}
