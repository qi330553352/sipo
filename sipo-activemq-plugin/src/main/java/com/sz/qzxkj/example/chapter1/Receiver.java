package com.sz.qzxkj.example.chapter1;

import com.sz.qzxkj.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 创 建 时 间: 2019/6/4
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Component
public class Receiver {

    private Logger log = LoggerFactory.getLogger(Receiver.class);

    @JmsListener(destination = "exaple-queue-01")
    public void readString(String text) {
        log.info("接收到消息：" + text);
    }
//    @JmsListener(destination = "exaple-queue-01")
//    public void readObj(UserInfo user) {
//        log.info("接收到消息：" + user);
//    }
}
