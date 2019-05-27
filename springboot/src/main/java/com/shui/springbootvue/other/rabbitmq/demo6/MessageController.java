package com.shui.springbootvue.other.rabbitmq.demo6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageController {
    @Autowired
    private MsgProducer msgProducer;

    @PostMapping("/sendMess")
    public void sendMess(String data){
        msgProducer.sendMsg(data);
    }
}
