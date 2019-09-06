package com.shui.springbootvue.test;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("test")
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(value = "/uploadUserInfo")
    public void uploadUserInfo(@RequestBody UploadUserInfoRequest uploadUserInfoRequest) {


        String postInfo = JSON.toJSONString(uploadUserInfoRequest);
        logger.info("E### - 用户源数据推送请求,参数={}", postInfo);

    }


    /**
     * 商品源接接收
     * @return
     */
    @PostMapping(value = "/uploadProductInfo", produces = "application/json;charset=UTF-8")
    public Wrapper uploadProductInfo(@RequestBody UploadProductInfoRequest uploadProductInfoRequest) {
        String postInfo = JSON.toJSONString(uploadProductInfoRequest);
        logger.info("E### - 商品源数据推送请求,参数={}", postInfo);
        return WrapMapper.ok();
    }
}
