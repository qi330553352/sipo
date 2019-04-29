package com.sz.qzxkj.design.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 创 建 时 间: 2019/4/29
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class TransactionalProxyImpl implements TransactionalProxy {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void test1() {
        log.info("----------test1() 111----------------"+this.getClass().getName());
    }

    @Override
    public void test2() {
        log.info("----------test2() 222----------------");
    }
}
