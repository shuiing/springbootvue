[toc]

## rabbitmq 中间件消息

## scheduling 定时任务
```
https://www.cnblogs.com/baixianlong/p/10659045.html
1、Quartz：可以去看看这篇文章[Quartz分布式]( https://www.cnblogs.com/jiafuwei/p/6145280.html)。
2、elastic-job：（https://github.com/elasticjob/elastic-job-lite）当当开发的弹性分布式任务调度系统，采用zookeeper实现分布式协调，实现任务高可用以及分片。
3、xxl-job:（https://github.com/xuxueli/xxl-job）是大众点评员发布的分布式任务调度平台，是一个轻量级分布式任务调度框架。
4、saturn:(https://github.com/vipshop/Saturn) 是唯品会提供一个分布式、容错和高可用的作业调度服务框架。
```
### demo1 静态定时任务
```
直接注释开启定时任务
只能一个一个任务执行
```
### demo2 动态定时任务（改接口）
```
在数据里改数据，这里没有用数据库
以后修改定时任务直接在数据库中修改即可
自动执行

实现SchedulingConfigurer接口，重写configureTasks方法，重新制定Trigger,
核心方法就是addTriggerTask(Runnable task, Trigger trigger) ，
注意：此方式修改配置值后，在下一次调度结束后，才会更新调度器，不会在修改配置值时实时更新，实时更新需要在修改配置值时额外增加相关逻辑处理。
```

### demo6 动态定时任务（改接口）
```
使用threadPoolTaskScheduler类可实现动态添加删除功能，当然也可实现执行频率的调整

threadPoolTaskScheduler是对java中ScheduledThreadPoolExecutor的一个封装改进后的产物，主要改进有以下几点：
      1、提供默认配置，因为是ScheduledThreadPoolExecutor，所以只有poolSize这一个默认参数。
      2、支持自定义任务，通过传入Trigger参数。
      3、对任务出错处理进行优化，如果是重复性的任务，不抛出异常，通过日志记录下来，不影响下次运行，如果是只执行一次的任务，将异常往上抛。
ThreadPoolTaskExecutor相对于ThreadPoolExecutor的改进点：
      1、提供默认配置，原生的ThreadPoolExecutor的除了ThreadFactory和RejectedExecutionHandler其他没有默认配置
      2、实现AsyncListenableTaskExecutor接口，支持对FutureTask添加success和fail的回调，任务成功或失败的时候回执行对应回调方法。
      3、因为是spring的工具类，所以抛出的RejectedExecutionException也会被转换为spring框架的TaskRejectedException异常(这个无所谓)
      4、提供默认ThreadFactory实现，直接通过参数重载配置

```

### demo3 多线程定时任务(异步)
```
多个任务互不影响
由于开启了多线程，第一个任务的执行时间也不受其本身执行时间的限制，所以需要注意可能会出现重复操作导致数据异常。
```

### demo4 多线程定时任务(线程池配置)
```
本质改变了任务调度器默认使用的线程池
配置线程池，启动demo1中直接注释的定时任务，可以同时执行10个定时任务
这里先注释掉
```

### demo5 多线程定时任务(线程池配置，异步)
```
与demo3相同，但是自定义线程池，方便控制

不改变调度器的默认线程池，而是把当前任务交给一个异步线程池去执行
1.在定时任务的方法加上@Async即可，默认使用的线程池为SimpleAsyncTaskExecutor（该线程池默认来一个任务创建一个线程，就会不断创建大量线程，极有可能压爆服务器内存。当然它有自己的限流机制，这里就不多说了，有兴趣的自己翻翻源码~）
2.项目中为了更好的控制线程的使用，我们可以自定义我们自己的线程池，使用方式@Async("myThreadPool")
```