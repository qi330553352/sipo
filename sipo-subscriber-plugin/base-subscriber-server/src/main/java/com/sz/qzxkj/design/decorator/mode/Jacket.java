package com.sz.qzxkj.design.decorator.mode;

/**
 * 创 建 时 间: 2019/4/30
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class Jacket extends ClothesDecorator {
    public Jacket(Person person) {
        super(person);
    }

    @Override
    public Double cost() {
        return person.cost() + 100; //夹克100元
    }

    @Override
    public void show() {
        person.show();
        System.out.println("穿上夹克，累计消费" + this.cost());
    }
}
