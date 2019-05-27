package com.sz.qzxkj.example.part1;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 创 建 时 间: 2019/5/27
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class ConnectionUtil {

    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.3.19");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("qixin");
        factory.setPassword("qixin123");
        return factory.newConnection();
    }


}
