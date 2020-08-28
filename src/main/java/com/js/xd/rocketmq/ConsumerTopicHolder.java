package com.js.xd.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;

import java.util.HashMap;
import java.util.Map;

public class ConsumerTopicHolder {

    private static Map<String, DefaultMQPushConsumer> consumers = new HashMap<>();

    public static void setConsumers(String key, DefaultMQPushConsumer defaultMQPushConsumer) {
        consumers.put(key, defaultMQPushConsumer);
    }

    public static Map<String, DefaultMQPushConsumer> getConsumers() {
        return consumers;
    }

    public static DefaultMQPushConsumer getDefaultMQPushConsumer(String key) throws  Exception {
        DefaultMQPushConsumer c = consumers.get(key);
        if (c == null) {
            throw new Exception("找不到消费者：" + key);
        }
        return c;
    }
}
