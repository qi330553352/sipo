package com.sz.qzxkj.example.part2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.sz.qzxkj.example.part1.ConnectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/** 工作队列之 轮询分发
 * 创 建 时 间: 2019/5/27
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class Send {
    public static final String QUEUE_NAME = "example-queue-01";
    private static Logger log = LoggerFactory.getLogger(Send.class);
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection conn = ConnectionUtil.getConnection();
        Channel channel = conn.createChannel(); //从连接中获得通道
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);//创建队列声明
        for(int i=0;i<50;i++){
            String msg = "Hello rabbitMQ: ["+i+"] "+System.currentTimeMillis();
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            Thread.sleep(200);
        }
        log.info("已发送50个消息");
        channel.close();
        conn.close();
    }
}
