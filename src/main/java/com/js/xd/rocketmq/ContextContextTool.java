package com.js.xd.rocketmq;

import com.js.xd.util.LoggerUtil;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class ContextContextTool {
    @Value("${apache.rocketmq.namesrvAddr}")
    private static String namesrvAddr;
    public void ContextTool(Boolean flag) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test_group");
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.subscribe("test_topic","*");
        if(flag){
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                    for (MessageExt msg : list) {
                        LoggerUtil.info("消费成功1-----"+new String (msg.getBody()));
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
        }else{
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                    for (MessageExt msg : list) {
                        LoggerUtil.info("更新切换监听代码-----"+ new String (msg.getBody()));
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
        }
        ConsumerTopicHolder.setConsumers("test_topic",consumer);
        consumer.start();
        LoggerUtil.info("创建消费者并启动监听：test_topic----ok");
    }
}
