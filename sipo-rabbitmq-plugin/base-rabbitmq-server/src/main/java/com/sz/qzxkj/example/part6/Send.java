package com.sz.qzxkj.example.part6;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.sz.qzxkj.example.part1.ConnectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/** routing路由模式
 * 创 建 时 间: 2019/5/27
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class Send {
    public static final String EXCHANG_NAME = "example-exchange-02";
    private static Logger log = LoggerFactory.getLogger(Send.class);
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection conn = ConnectionUtil.getConnection();
        Channel channel = conn.createChannel(); //从连接中获得通道
        channel.exchangeDeclare(EXCHANG_NAME,"direct");//声明交换机 分发

        String routingKey = "error";
        for(int i=0;i<50;i++){
            String msg = "Hello rabbitMQ: ["+i+"] "+System.currentTimeMillis();
            channel.basicPublish(EXCHANG_NAME,routingKey,null,msg.getBytes());
            log.info("已发送:"+msg);
        }

        channel.close();
        conn.close();
    }
}
