package com.js.xd.util;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;

public interface ITransactionRocketMqUtil {

    TransactionSendResult transactionSend (String topic, String msg) throws Exception;

}
