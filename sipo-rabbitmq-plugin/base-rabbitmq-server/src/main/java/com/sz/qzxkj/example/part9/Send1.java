package com.sz.qzxkj.example.part9;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.sz.qzxkj.example.part1.ConnectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/** confirm 1、普通模式
 * 创 建 时 间: 2019/5/27
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class Send1 {
    public static final String QUEUE_NAME = "example-queue-09";
    private static Logger log = LoggerFactory.getLogger(Send1.class);
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection conn = ConnectionUtil.getConnection();
        Channel channel = conn.createChannel(); //从连接中获得通道
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);//创建队列声明

        channel.confirmSelect();//设置为confirm模式

        String msg = "Hello rabbitMQ:"+System.currentTimeMillis();
        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
        if(channel.waitForConfirms()){
            log.info("已发送成功:"+msg);
        }else{
            log.error("消息发送失败...");
        }
        channel.close();
        conn.close();
    }
}
