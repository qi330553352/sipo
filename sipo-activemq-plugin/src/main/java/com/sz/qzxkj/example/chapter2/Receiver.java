package com.sz.qzxkj.example.chapter2;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 创 建 时 间: 2019/6/4
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class Receiver {

    private static String ACTIVEMQ_URL = "tcp://192.168.147.131:61616";
    private static String QUEUE_NAME = "exaple-queue-01";

    public static void main(String[] args)throws Exception{
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(//
                ActiveMQConnectionFactory.DEFAULT_USER,//
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,//
                ACTIVEMQ_URL);//创建连接工厂
        Connection connection = activeMQConnectionFactory.createConnection();//创建连接
        connection.start();//打开连接
        //参数1：是否启用事务    参数2：签收模式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//创建会话
        Destination destination = session.createQueue(QUEUE_NAME);//创建队列目标
        javax.jms.MessageConsumer consumer = session.createConsumer(destination);//创建消费者
        //创建消费的监听
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("获取消息：" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
