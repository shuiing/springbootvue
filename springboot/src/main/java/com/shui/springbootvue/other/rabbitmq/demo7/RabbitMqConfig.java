package com.shui.springbootvue.other.rabbitmq.demo7;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * 三种类型得交换机
 */
//@Configuration
//@PropertySource(value = "classpath:application-dev.properties")
public class RabbitMqConfig {
//
//    @Value("${rabbitmq.host}")
//    private String host;
//
//    @Value("${rabbitmq.port}")
//    private Integer port;
//
//    @Value("${rabbitmq.username}")
//    private String username;
//
//    @Value("${rabbitmq.password}")
//    private String password;
//
//    /**
//     * 通过 AbstractConnectionFactory 获取到内部 rabbitConnectionFactory
//     *
//     * @return
//     */
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
//        connectionFactory.setHost(host);
//        connectionFactory.setPort(port);
//        connectionFactory.setUsername(username);
//        connectionFactory.setPassword(password);
//        /**消息确认*/
//        connectionFactory.setPublisherConfirms(true);
//        /**消息回调*/
//        connectionFactory.setPublisherReturns(true);
//        /**消费者的ack方式为手动*/
//
//        return connectionFactory;
//    }
//
//    /**
//     * 定义了 AMQP 基础管理操作，主要是对各种资源（交换机、队列、绑定）的申明和删除操作。
//     *
//     * @param connectionFactory
//     * @return
//     */
//    @Bean
//    RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
//        RabbitAdmin admin = new RabbitAdmin(connectionFactory);
//
//        //创建队列和交换机以及绑定
//
//        /**
//         * DIRECT
//         *
//         * direct : 通过路由键 消息将被投送到对应的队列(一对一)
//         */
//        admin.declareQueue(new Queue("Direct-Queue"));
//
//        //该交换机里面的三个参数分别为: 名字,持久化,是否自动删除
//        admin.declareExchange(new DirectExchange("Joe-Direct", false, false));
//
//        Binding direct = BindingBuilder.bind(new Queue("Direct-Queue"))
//                .to(new DirectExchange("Joe-Direct", true, false)).with("Direct-RoutingKey");
//        admin.declareBinding(direct);
//
//        /**
//         * FANOUT
//         *
//         * 发布订阅模式(不存在路由键 将被投放到exchange对应的队列中)
//         */
//        admin.declareQueue(new Queue("Fanout-Queue-1"));
//        admin.declareQueue(new Queue("Fanout-Queue-2"));
//        admin.declareQueue(new Queue("Fanout-Queue-3"));
//
//        admin.declareExchange(new FanoutExchange("Joe-Fanout", false, false));
//
//        Binding fanout1 = BindingBuilder.bind(new Queue("Fanout-Queue-1"))
//                .to(new FanoutExchange("Joe-Fanout", false, false));
//
//        Binding fanout2 = BindingBuilder.bind(new Queue("Fanout-Queue-2"))
//                .to(new FanoutExchange("Joe-Fanout", false, false));
//
//        Binding fanout3 = BindingBuilder.bind(new Queue("Fanout-Queue-3"))
//                .to(new FanoutExchange("Joe-Fanout", false, false));
//
//        admin.declareBinding(fanout1);
//        admin.declareBinding(fanout2);
//        admin.declareBinding(fanout3);
//
//        /**
//         * Topic
//         *
//         * 可以使得不同源头的数据投放到一个队列中(order.log , order.id, purchase.log, purchase.id)
//         *
//         * 通过路由键的命名分类来进行筛选
//         */
//        admin.declareQueue(new Queue("Topic-Queue-1"));
//        admin.declareQueue(new Queue("Topic-Queue-2"));
//        admin.declareQueue(new Queue("Topic-Queue-3"));
//
//        admin.declareExchange(new TopicExchange("Joe-Topic", false, false));
//
//        Binding topic1 = BindingBuilder.bind(new Queue("Topic-Queue-1"))
//                .to(new TopicExchange("Joe-Topic", false, false)).with("*.to");
//
//        Binding topic2 = BindingBuilder.bind(new Queue("Topic-Queue-2"))
//                .to(new TopicExchange("Joe-Topic", false, false)).with("log.*");
//
//        Binding topic3 = BindingBuilder.bind(new Queue("Topic-Queue-3"))
//                .to(new TopicExchange("Joe-Topic", false, false)).with("log1.to");
//
//        admin.declareBinding(topic1);
//        admin.declareBinding(topic2);
//        admin.declareBinding(topic3);
//
//        return admin;
//    }

}
