package com.sz.qzxkj.design.decorator.mode;

/**
 * 创 建 时 间: 2019/4/30
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class Hat extends ClothesDecorator {
    public Hat(Person person) {
        super(person);
    }

    @Override
    public Double cost() {
        return person.cost() + 50; //帽子50元
    }

    @Override
    public void show() {
        //执行已有功能
        person.show();
        //此处是附加的功能
        System.out.println("戴上帽子，累计消费" + this.cost());
    }
}
