package com.shui.springbootvue.other.scheduling;

import com.shui.springbootvue.other.scheduling.demo2.DynamicScheduleTask;
import com.shui.springbootvue.other.scheduling.demo6.DynamicTimedTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定时任务
 */
@RestController
@RequestMapping("schedu")
public class SchedulingCtl {

    @Autowired
    private DynamicTimedTask dynamicTimedTask;

    //开启定时
    @PostMapping("/startCron")
    public void startCron(){
       dynamicTimedTask.startCron();
    }

    //停止定时
    @PostMapping("/stopCron")
    public void stopCron(){
        dynamicTimedTask.stopCron();
    }
}
