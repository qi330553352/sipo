package com.sz.qzxkj.design.observer.model.publishSubscribe;

/**
 * 创 建 时 间: 2019/5/1
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public interface ISubject {

    void registerObserver(Observable observer);
    void removeObserver(Observable observer);
    void notifyObservers();
}
