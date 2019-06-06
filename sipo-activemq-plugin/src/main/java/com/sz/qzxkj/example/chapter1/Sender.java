package com.sz.qzxkj.example.chapter1;

import com.sz.qzxkj.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * 创 建 时 间: 2019/6/4
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Component
public class Sender {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    private Logger log = LoggerFactory.getLogger(Sender.class);

    public void sendString(){
        String msg = "chapter1"+System.currentTimeMillis();

        jmsMessagingTemplate.convertAndSend("exaple-queue-01",msg);
        log.info("已发送消息:"+msg);
    }

    public void sendObj(){
        String msg = "chapter1"+System.currentTimeMillis();
        UserInfo user = new UserInfo();
        user.setUsername("exampleName"+msg);
        user.setPassword("123456");
        jmsMessagingTemplate.convertAndSend("exaple-queue-01",user);
    }
}
