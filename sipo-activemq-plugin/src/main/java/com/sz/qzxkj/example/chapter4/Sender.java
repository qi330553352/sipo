package com.sz.qzxkj.example.chapter4;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Session;
import javax.jms.TextMessage;

/** 使用client端方式签收
 * 创 建 时 间: 2019/6/6
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class Sender {


    private static String ACTIVEMQ_URL = "tcp://192.168.147.131:61616";
    private static String QUEUE_NAME = "exaple-queue-01";

    public static void main(String[] args)throws Exception{
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(//
                ActiveMQConnectionFactory.DEFAULT_USER,//
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,//
                ACTIVEMQ_URL);//创建连接工厂
        Connection connection = activeMQConnectionFactory.createConnection();//创建连接
        connection.start();//打开连接

        Session session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);//使用client端方式签收

        Destination destination = session.createQueue(QUEUE_NAME);//创建队列目标
        javax.jms.MessageProducer producer = session.createProducer(destination);//创建一个生产者
        //创建模拟100个消息
        for (int i = 1 ; i <= 100 ; i++){
            TextMessage message = session.createTextMessage("我发送message:" + i);
            //发送消息
            producer.send(message);
            //在本地打印消息
            System.out.println("我现在发的消息是：" + message.getText());
        }
        session.commit();
        connection.close();//关闭连接
    }
}
