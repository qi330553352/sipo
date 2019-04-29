package com.sz.qzxkj.design.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * 创 建 时 间: 2019/4/29
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class TransactionalProxyHandler implements InvocationHandler {

    private TransactionalProxy target;
    private Logger log = LoggerFactory.getLogger(this.getClass());
    public TransactionalProxyHandler(TransactionalProxy target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        //日志记录
        //权限控制
        //事务控制
        log.info("代理对象做些其它业务...");

        return method.invoke(target,objects);
    }
}
