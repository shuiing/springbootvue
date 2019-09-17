package com.shui.client.demo;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


@FeignClient(value = "cloud-feign", configuration = DemoConfig.class)
//@FeignClient(value = "cloud-feign", configuration = DemoInteface.MultipartSupportConfig.class)
public interface DemoInteface {

    /**
     * 发送文件
     */
    @PostMapping(value = "/getFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String sendFile(@RequestPart(value = "file") MultipartFile file);

//    @Configuration
//    class MultipartSupportConfig {
//        @Bean
//        public Encoder multipartFormEncoder() {
//            return new SpringFormEncoder(new SpringEncoder(new ObjectFactory<HttpMessageConverters>() {
//                @Override
//                public HttpMessageConverters getObject() throws BeansException {
//                    return new HttpMessageConverters(new RestTemplate().getMessageConverters());
//                }
//            }));
//        }
//    }


    @GetMapping("/testfegin")
    String fegin();
}
