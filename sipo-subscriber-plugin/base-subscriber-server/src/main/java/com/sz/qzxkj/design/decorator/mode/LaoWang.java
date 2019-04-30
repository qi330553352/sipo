package com.sz.qzxkj.design.decorator.mode;

/**
 * 创 建 时 间: 2019/4/30
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class LaoWang implements Person {
    @Override
    public Double cost() {
        return 0.0; //赤果果的时候累计消费为0
    }

    @Override
    public void show() {
        System.out.println("我是赤果果的老王");
    }
}
