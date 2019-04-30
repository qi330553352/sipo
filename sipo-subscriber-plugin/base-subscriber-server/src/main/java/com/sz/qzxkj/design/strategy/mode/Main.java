package com.sz.qzxkj.design.strategy.mode;

/**
 * 创 建 时 间: 2019/4/30
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class Main {


    public static void main(String[] args){
        Calculator calculator = new Calculator();
        calculator.setOperation(new OperationAdd());
        int result = calculator.doOperation(1,2);
        System.out.println(result);
    }

}
