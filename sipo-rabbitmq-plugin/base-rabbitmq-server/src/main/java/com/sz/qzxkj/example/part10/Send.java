package com.sz.qzxkj.example.part10;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.sz.qzxkj.example.part1.ConnectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeoutException;

/** confirm 1、普通模式
 * 创 建 时 间: 2019/5/27
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class Send {
    public static final String QUEUE_NAME = "example-queue-10";
    private static Logger log = LoggerFactory.getLogger(Send.class);
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection conn = ConnectionUtil.getConnection();
        Channel channel = conn.createChannel(); //从连接中获得通道
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);//创建队列声明

        channel.confirmSelect();//设置为confirm模式
        //未确认的消息标识
        final SortedSet<Long> confirmSet = Collections.synchronizedSortedSet(new TreeSet<>());
        channel.addConfirmListener(new ConfirmListener() {
            @Override //回执成功
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                if(multiple){
                    log.info("--handleAck------------multiple:true");
                    confirmSet.headSet(deliveryTag+1).clear();
                }else{
                    log.info("--handleAck------------multiple:false");
                    confirmSet.remove(deliveryTag);
                }
            }

            @Override //回执有问题的
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                if(multiple){
                    log.info("--handleNack------------multiple:true");
                    confirmSet.headSet(deliveryTag+1).clear();
                }else{
                    log.info("--handleNack------------multiple:false");
                    confirmSet.remove(deliveryTag);
                }
            }
        });

        int i = 0;
        while (true){
            ++i;
            long seqNo = channel.getNextPublishSeqNo();
            String msg = "Hello rabbitMQ: ["+i+"] "+System.currentTimeMillis();
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            confirmSet.add(seqNo);
        }
    }
}
