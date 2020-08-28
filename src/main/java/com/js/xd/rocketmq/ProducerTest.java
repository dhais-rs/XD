package com.js.xd.rocketmq;

import com.js.xd.util.ITransactionRocketMqUtil;
import com.js.xd.util.LoggerUtil;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ProducerTest {
    @Value("${apache.rocketmq.producer.producerGroup}")
    private String transactionTopicGroup;
    @Value("${apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;
    @Autowired
    private ITransactionRocketMqUtil transactionRocketMqUtil;



    public void sendProducerTransaction() throws Exception {
//        producer.sendMessageInTransaction(new Message("test_topic","test_msg".getBytes()),null);
//        DefaultMQProducer producer = new DefaultMQProducer("default_producer_group");
//        producer.setNamesrvAddr(namesrvAddr);
//        producer.setClientIP("192.168.147.1");
//        producer.setVipChannelEnabled(false);
//        producer.start();
//        TransactionSendResult result = producer.sendMessageInTransaction(new Message("test_topic","test_msg".getBytes()),null);
        TransactionSendResult result = transactionRocketMqUtil.transactionSend("test_topic","test_msg");
        Map<String,DefaultMQPushConsumer> consumers = ConsumerTopicHolder.getConsumers();
        if(consumers.containsKey("test_topic")){
            DefaultMQPushConsumer consumer = consumers.get("test_topic");
            consumer.shutdown();
            LoggerUtil.info("关闭旧consumer test_topic监听");
            new ContextContextTool().ContextTool(false);
        }
        LoggerUtil.info("发送半消息到rocketmq事务监听"+result);
    }
}
