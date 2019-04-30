package com.sz.qzxkj.design.decorator.mode;

/**
 * 创 建 时 间: 2019/4/30
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class Main {

    public static void main(String[] args){
        Person laowang = new LaoWang();
        //穿上夹克
        laowang = new Jacket(laowang);
        //戴上帽子
        laowang = new Hat(laowang);

        laowang.show();
        System.out.println("买单，老王总共消费："+laowang.cost());
    }
}
