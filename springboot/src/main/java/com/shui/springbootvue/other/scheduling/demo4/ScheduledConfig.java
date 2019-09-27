package com.shui.springbootvue.other.scheduling.demo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.ThreadPoolExecutor;
//

/**
 * 多线程定时任务(线程池配置)
 */

//@Configuration
public class ScheduledConfig {
//public class ScheduledConfig implements SchedulingConfigurer {
//
//    @Autowired
//    private TaskScheduler myThreadPoolTaskScheduler;
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        //简单粗暴的方式直接指定
//        //scheduledTaskRegistrar.setScheduler(Executors.newScheduledThreadPool(10));
//        //也可以自定义的线程池，方便线程的使用与维护，这里不多说了
//        scheduledTaskRegistrar.setTaskScheduler(myThreadPoolTaskScheduler);
//    }
//
//
//    @Bean(name = "myThreadPoolTaskScheduler")
//    public TaskScheduler getMyThreadPoolTaskScheduler() {
//        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
//        taskScheduler.setPoolSize(10);
//        taskScheduler.setThreadNamePrefix("Haina-Scheduled-");
//        taskScheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        //调度器shutdown被调用时等待当前被调度的任务完成
//        taskScheduler.setWaitForTasksToCompleteOnShutdown(true);
//        //等待时长
//        taskScheduler.setAwaitTerminationSeconds(60);
//        return taskScheduler;
//    }
}