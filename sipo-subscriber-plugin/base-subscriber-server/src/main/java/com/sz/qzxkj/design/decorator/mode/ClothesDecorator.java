package com.sz.qzxkj.design.decorator.mode;

/**
 * 创 建 时 间: 2019/4/30
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public abstract class ClothesDecorator implements Person{


    //装饰器中要使用被装饰器的对象，构造方法中传入
    protected Person person;

    public ClothesDecorator(Person person){
        this.person = person;
    }
}
