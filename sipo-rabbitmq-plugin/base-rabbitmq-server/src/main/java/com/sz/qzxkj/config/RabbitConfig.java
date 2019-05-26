package com.sz.qzxkj.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 创 建 时 间: 2019/5/23
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Configuration
public class RabbitConfig {

    final static String message = "topic.message";
    final static String messages = "topic.messages";

    @Bean   //队列配置
    public Queue queue(){

        return new Queue("exaple-queue-01");
    }

    //------Topic Exchange   start -------chapter3--------------
    @Bean
    public Queue queueMessage() {
        return new Queue(RabbitConfig.message);
    }
    @Bean
    public Queue queueMessages() {
        return new Queue(RabbitConfig.messages);
    }
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
    //------Topic Exchange   end ---------chapter3------------

    //------Fanout Exchange   start ---------chapter4---------
    @Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }
    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }
    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }
    @Bean
    Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }
    //------Fanout Exchange   end ---------chapter4---------
}
