package com.sz.qzxkj.example.part9;

import com.rabbitmq.client.*;
import com.sz.qzxkj.example.part1.ConnectionUtil;
import com.sz.qzxkj.example.part1.Send;
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
public class Recv1 {
    private static Logger log = LoggerFactory.getLogger(Recv1.class);
    public static final String QUEUE_NAME = "example-queue-09";
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection conn = ConnectionUtil.getConnection();
        Channel channel = conn.createChannel(); //从连接中获得通道
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);//创建队列声明
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override //事件模型
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body,"UTF-8");
                log.info("收到消息:"+msg);
            }
        };
        channel.basicConsume(QUEUE_NAME,true,consumer); //监听队列
    }
}
