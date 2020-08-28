package com.js.xd.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.js.xd.util.ITransactionRocketMqUtil;
import com.js.xd.util.LoggerUtil;
import com.js.xd.util.TransactionRocketMqUtil;
import org.apache.ibatis.logging.Log;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

@Configuration
public class rocketMqConfig {

    @Value("${apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;

    private static final String PRODUCER_GROUP = "xd_producer_group";

    @Bean
    public ITransactionRocketMqUtil rocketMqUtilSs(){

        TransactionMQProducer producer = new TransactionMQProducer(PRODUCER_GROUP);
        producer.setVipChannelEnabled(false);
        producer.setNamesrvAddr(namesrvAddr);
        //创建一个自定义线程工厂
        ThreadFactory threadFactory =
                new ThreadFactoryBuilder().setNameFormat("transaction-thread-name-%s").build();
        //创建一个线程池
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(
                        2, 5, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(30), threadFactory);
        //设置生产者线程池
        producer.setExecutorService(executor);
        //设置事务监听器
        producer.setTransactionListener(new TransactionListener() {
            @Override
            public LocalTransactionState executeLocalTransaction(Message message, Object o) {
                try {
                    LoggerUtil.info("开始事务处理");
                    System.out.println(1/1);
                    LoggerUtil.info("完成事务");
                    return LocalTransactionState.COMMIT_MESSAGE;
                }catch (Exception e){
                    LoggerUtil.info("失败事务");
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                }finally {
                    LoggerUtil.info("事务处理结束");
                }
            }

            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
                try {
                    LoggerUtil.info("开始事务回查");
                    System.out.println(1/1);
                    return LocalTransactionState.COMMIT_MESSAGE;
                }catch (Exception e){
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                }finally {
                    LoggerUtil.info("事务回查结束");
                }
            }
        });
        return new TransactionRocketMqUtil(producer);
    }
}
