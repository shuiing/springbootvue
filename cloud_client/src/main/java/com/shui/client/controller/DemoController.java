package com.shui.client.controller;

import com.shui.client.demo.DemoInteface;
import com.shui.client.mapper.TPurchaseOrderMapper;
import com.shui.client.model.TPurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 测试
 */

@RestController
public class DemoController {

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    private DemoInteface demoInteface;
    @Autowired
    private TPurchaseOrderMapper tPurchaseOrderMapper;

    @Value("${info.profile}")
    private String info;

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


    //调用其他服务的接口
    @GetMapping("/demoFegin")
    public String demoFegin() {
        return demoInteface.fegin();
    }


    //接收文件，并发送文件
    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void fileUpload(@RequestPart MultipartFile file) {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(demoInteface.sendFile(file));
    }

    /**
     * 获取配置
     * @return
     */
    @GetMapping("/info")
    public String getInfo(){
        return info;
    }

    @GetMapping("/mysql")
    public List<TPurchaseOrder> getMysql(){
        return tPurchaseOrderMapper.selectAll();
    }
}
