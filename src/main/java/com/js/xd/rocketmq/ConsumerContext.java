package com.js.xd.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.List;
@Configuration
public class ConsumerContext {

    private DefaultMQPushConsumer consumer;

    @Value("${apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;
    @Bean
    public ContextContextTool testConsumer() throws Exception {
//        consumer = new DefaultMQPushConsumer("test_group");
//        consumer.setNamesrvAddr(namesrvAddr);
//        consumer.subscribe("test_topic","*");
//        consumer.registerMessageListener(new MessageListenerConcurrently() {
//            @Override
//            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
//                for (MessageExt msg : list) {
//                    System.out.println("消费成功"+msg);
//                }
//                return null;
//            }
//        });
//        consumer.start();
//        System.out.println("创建消费者并启动监听：test_topic");
        new ContextContextTool().ContextTool(true);
        return null;
    }
}
