package com.sz.qzxkj.example.multithreading.part4.tranfer.service;

import com.sz.qzxkj.example.multithreading.part4.tranfer.UserAccount;

/**类说明：银行转账动作接口
 * 创 建 时 间: 2019/5/6
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public interface ITransfer {
    void transfer(UserAccount from, UserAccount to, int amount) throws InterruptedException;
}
