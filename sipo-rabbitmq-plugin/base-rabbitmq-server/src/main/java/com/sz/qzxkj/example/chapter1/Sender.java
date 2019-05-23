package com.sz.qzxkj.example.chapter1;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 创 建 时 间: 2019/5/23
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String msg = "chapter1"+System.currentTimeMillis();

        amqpTemplate.convertAndSend("exaple-queue-01",msg);
    }
}
