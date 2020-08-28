package com.js.xd.util;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;

public class TransactionRocketMqUtil implements ITransactionRocketMqUtil {

    private TransactionMQProducer producer;

    public TransactionRocketMqUtil(TransactionMQProducer producer){
        LoggerUtil.info("初始化类");
        this.producer = producer;
        start();
    }

    public TransactionSendResult transactionSend (String topic,String msg) throws Exception {
        Message message = new Message(topic,msg.getBytes());
        TransactionSendResult result =  producer.sendMessageInTransaction(message,null);
        return result;
    }

    public void shutdown(){
        this.producer.shutdown();
    }

    /**
     * 使用前先调用start方法
     */
    public void start(){
        try {
            this.producer.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
