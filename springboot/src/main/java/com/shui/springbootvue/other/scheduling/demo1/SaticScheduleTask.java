package com.shui.springbootvue.other.scheduling.demo1;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 静态定时任务
 * 缺点：同时执行任务时，只能一个一个执行任务
 * @Scheduled：除了支持灵活的参数表达式cron之外，还支持简单的延时操作，例如 fixedDelay ，fixedRate 填写相应的毫秒数即可。
 */

@Component
@Configuration      //主要用于标记配置类，兼备Component的效果。
//@EnableScheduling   //开启定时任务
public class SaticScheduleTask {
    //3.添加定时任务
    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }
}