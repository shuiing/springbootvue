package com.shui.springbootvue.other.scheduling.demo5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 多线程定时任务(线程池配置，异步)
 */

@Component
//@EnableScheduling   // 1.开启定时任务
@EnableAsync
@Configuration
public class ScheduledAsync {

//    @Scheduled(fixedRate = 100*10,initialDelay = 100*20)
    @Async("myThreadPoolTaskExecutor")
    //@Async
    public void scheduledTest02(){
        System.out.println(Thread.currentThread().getName()+"--->xxxxx--->"+Thread.currentThread().getId());
    }

//    @Async("myThreadPoolTaskExecutor")
//    @Scheduled(fixedDelay = 2000)
//    public void second() {
//        System.out.println("线程池第二个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
//        System.out.println();
//    }
//
//    @Async("myThreadPoolTaskExecutor")
//    @Scheduled(fixedDelay = 1000)  //间隔1秒
//    public void first() throws InterruptedException {
//        System.out.println("线程池第一个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
//        System.out.println();
//        Thread.sleep(1000 * 10);
//    }

    //自定义线程池
    @Bean(name = "myThreadPoolTaskExecutor")
    public TaskExecutor getMyThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(20);
        taskExecutor.setMaxPoolSize(200);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.setKeepAliveSeconds(200);
        taskExecutor.setThreadNamePrefix("Haina-ThreadPool-");
        // 线程池对拒绝任务（无线程可用）的处理策略，目前只支持AbortPolicy、CallerRunsPolicy；默认为后者
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //调度器shutdown被调用时等待当前被调度的任务完成
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        //等待时长
        taskExecutor.setAwaitTerminationSeconds(60);
        taskExecutor.initialize();
        return taskExecutor;
    }
}
