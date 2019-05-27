package com.sz.qzxkj.example.part3;

import com.rabbitmq.client.*;
import com.sz.qzxkj.example.part1.ConnectionUtil;
import com.sz.qzxkj.example.part1.Send;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 创 建 时 间: 2019/5/27
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class Recv2 {
    private static Logger log = LoggerFactory.getLogger(Recv2.class);

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection conn = ConnectionUtil.getConnection();
        Channel channel = conn.createChannel(); //从连接中获得通道
        channel.queueDeclare(Send.QUEUE_NAME,false,false,false,null);//创建队列声明
        channel.basicQos(1); //一次只处理一个消息
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override //事件模型
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body,"UTF-8");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("收到消息:"+msg);
                channel.basicAck(envelope.getDeliveryTag(),false); //返回一个回值给消息生产者
            }
        };
        boolean autoAck = false; //自动应答
        channel.basicConsume(Send.QUEUE_NAME,autoAck,consumer); //监听队列
    }
}
