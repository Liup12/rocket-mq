package com.xuande.consumer.config;


import com.xuande.consumer.properties.RocketProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MQConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MQProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author : xuande
 * @date : 2022-05-03 10:11
 **/
@Configuration
@Slf4j
public class RocketMqConfig {

    @Resource
    private RocketProperties rocketProperties;

    @Resource
    private MessageListener listener;

    @Bean
    public MQProducer defaultMQProducer(){
        DefaultMQProducer producer = new DefaultMQProducer(rocketProperties.getGroup());

        producer.setNamesrvAddr(rocketProperties.getServer());

        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }

        return producer;
    }



    @Bean
    public MQConsumer defaultMQConsumer(){
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(rocketProperties.getGroup());

        consumer.setNamesrvAddr(rocketProperties.getServer());
        consumer.registerMessageListener(listener);
        try {
            consumer.subscribe(rocketProperties.getMessageTopic(),"*");
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        System.out.printf("Consumer Started.%n");
        return consumer;
    }
}
