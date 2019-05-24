package com.shui.springbootvue.other.scheduling.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 动态定时任务
 * 这里添加的是TriggerTask，目的是循环读取我们在数据库设置好的执行周期，以及执行相关定时任务的内容。
 */

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
//@EnableScheduling   // 2.开启定时任务
public class DynamicScheduleTask implements SchedulingConfigurer {

//    @Mapper
//    public interface CronMapper {
//        @Select("select cron from cron limit 1")
//        public String getCron();
//    }

//    @Autowired      //注入mapper
//    @SuppressWarnings("all") //忽略警告
//    CronMapper cronMapper;

    /**
     * 执行定时任务.
     */

    /*
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        taskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                () -> System.out.println("执行动态定时任务1: " + LocalDateTime.now().toLocalTime()),
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1 从数据库获取执行周期
//                    String cron = cronMapper.getCron();
                    String cron = "0/5 * * * * ?";
                    //2.2 合法性校验.
                    if (StringUtils.isEmpty(cron)) {
                        // Omitted Code ..
                    }
                    //2.3 返回执行周期(Date)
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
*/

    private static String cron;

    //修改之后的cron
    public static void setCron(String cron) {
        DynamicScheduleTask.cron = cron;
    }

    public DynamicScheduleTask() {
        //默认的cron
//        cron = "0/5 * * * * ?";
        cron = "";//关闭定时任务
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                doSomething();//自定义任务
            }
        }, new Trigger() {
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
    }

    public void doSomething(){
        System.out.println("执行动态定时任务2: " + LocalDateTime.now().toLocalTime());
    }
}


/**
 *
 * () -> System.out.println("执行动态定时任务: " + LocalDateTime.now().toLocalTime()),
 * 相当于 匿名内部类
 * new Runnable() {
 *     @Override
 *     public void run() {
 *         System.out.println("执行动态定时任务: " + LocalDateTime.now().toLocalTime());
 *     }
 * };
 *
 */