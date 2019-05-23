package com.sz.qzxkj.example.chapter2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/** A.	direct（发布与订阅、完全匹配）
 * 创 建 时 间: 2019/5/23
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Component
@RabbitListener(
        bindings =
        @QueueBinding(
                value = @Queue(value = "${mq.config.queue.error}",autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange}"),
                key = "${mq.config.queue.error.routing.key}"
        )
)
public class ErrorReceiver {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(String msg){
        log.info("接收到Error日志:"+msg);
    }
}
