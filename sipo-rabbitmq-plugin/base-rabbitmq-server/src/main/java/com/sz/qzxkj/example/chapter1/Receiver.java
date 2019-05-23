package com.sz.qzxkj.example.chapter1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 创 建 时 间: 2019/5/23
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Component
public class Receiver {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RabbitListener(queues = "exaple-queue-01")
    public void process(String msg){
        log.info("收到队列的消息了:"+msg);
    }
}
