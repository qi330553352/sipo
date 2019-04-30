package com.sz.qzxkj.design.strategy.mode;

/** 计算器类
 * 创 建 时 间: 2019/4/30
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class Calculator {

    private Operation operation;

    public void setOperation(Operation operation){
        this.operation = operation;
    }

    public int doOperation(int num1, int num2){
        return this.operation.doOperation(num1,num2);
    }
}
