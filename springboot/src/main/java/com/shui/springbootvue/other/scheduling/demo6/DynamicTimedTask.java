package com.shui.springbootvue.other.scheduling.demo6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;

@Component
public class DynamicTimedTask {

    private static final Logger logger = LoggerFactory.getLogger(DynamicTimedTask.class);

//    利用创建好的调度类统一管理
    @Autowired
    @Qualifier("myThreadPoolTaskScheduler")
    private ThreadPoolTaskScheduler myThreadPoolTaskScheduler;


    //接受任务的返回结果
    private ScheduledFuture<?> future;

//    @Autowired
//    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

//    //实例化一个线程池任务调度类,可以使用自定义的ThreadPoolTaskScheduler
//    @Bean
//    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
//        ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
//        return new ThreadPoolTaskScheduler();
//    }

    //自定义线程池
    @Bean(name = "myThreadPoolTaskScheduler")
    public ThreadPoolTaskScheduler getMyThreadPoolTaskScheduler() {
        // 创建一个线程池对象
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        // 定义一个线程池大小
        scheduler.setPoolSize(20);
        // 线程池名的前缀
        scheduler.setThreadNamePrefix("taskExecutor-");
        // 设置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        // 设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住
        scheduler.setAwaitTerminationSeconds(60);
        // 线程池对拒绝任务的处理策略,当线程池没有处理能力的时候，该策略会直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
        scheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return scheduler;
    }

    /**
     * 启动定时任务
     * @return
     */
    public boolean startCron() {
        boolean flag = false;
        //从数据库动态获取执行周期
        String cron = "0/2 * * * * ? ";
//        future = threadPoolTaskScheduler.schedule(new CheckModelFile(),);//另一中写法
//        future = threadPoolTaskScheduler.schedule(new Runnable() {
        future = myThreadPoolTaskScheduler.schedule(new Runnable() {//自定义的
            @Override
            public void run() {
                doSomething();//自定义任务
            }
        },new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
//                合法性校验.
                if (StringUtils.isEmpty(cron)) {
                    // Omitted Code ..
                    return null;
                }
                CronTrigger trigger=new CronTrigger(cron);
                return trigger.nextExecutionTime(triggerContext);
            }
        });
        if (future!=null){
            flag = true;
            logger.info("定时check训练模型文件,任务启动成功！！！");
        }else {
            logger.info("定时check训练模型文件,任务启动失败！！！");
        }
        return flag;
    }

    /**
     * 停止定时任务
     * @return
     */
    public boolean stopCron() {
        boolean flag = false;
        if (future != null) {
            logger.info("定时",future);
            boolean cancel = future.cancel(true);
            if (cancel){
                flag = true;
                logger.info("定时check训练模型文件,任务停止成功！！！");
            }else {
                logger.info("定时check训练模型文件,任务停止失败！！！");
            }
        }else {
            flag = true;
            logger.info("定时check训练模型文件，任务已经停止！！！");
        }
        return flag;
    }


    class CheckModelFile implements Runnable{
        @Override
        public void run() {
            //编写你自己的业务逻辑
            System.out.print("模型文件检查完毕！！！");
        }
    }

    public void doSomething(){
        System.out.println("定时任务: " + LocalDateTime.now().toLocalTime());
    }

}