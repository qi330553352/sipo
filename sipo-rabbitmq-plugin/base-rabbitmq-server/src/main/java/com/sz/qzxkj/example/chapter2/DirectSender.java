package com.sz.qzxkj.example.chapter2;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** A.	direct（发布与订阅、完全匹配）
 * 创 建 时 间: 2019/5/23
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Component
public class DirectSender {

    @Autowired
    private AmqpTemplate amqpTemplate;
    @Value("${mq.config.exchange}")
    private String exchange;

    public void send(){
        String msg = "chapter1"+System.currentTimeMillis();
        //交换器、路由键、消息
        amqpTemplate.convertAndSend(exchange,"log.info.routing.key",msg);
    }
}
