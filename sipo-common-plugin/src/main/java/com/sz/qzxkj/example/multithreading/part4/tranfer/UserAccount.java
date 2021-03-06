package com.sz.qzxkj.example.multithreading.part4.tranfer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**类说明：用户账户的实体类
 * 创 建 时 间: 2019/5/6
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class UserAccount {

    private String name;//账户名称
    private int money;//账户余额
    private final Lock lock = new ReentrantLock();

    public Lock getLock() {
        return lock;
    }

    public UserAccount(String name, int amount) {
        this.name = name;
        this.money = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return money;
    }

    //转入资金
    public void addMoney(int amount) {
        money = money + amount;
    }

    //转出资金
    public void flyMoney(int amount) {
        money = money - amount;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
