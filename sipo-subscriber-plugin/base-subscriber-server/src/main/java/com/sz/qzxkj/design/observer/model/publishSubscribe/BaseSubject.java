package com.sz.qzxkj.design.observer.model.publishSubscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * 创 建 时 间: 2019/5/1
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public abstract class BaseSubject implements ISubject{
    private List<Observable> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observable observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observable observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observable observer : observers){
            observer.update();
        }
    }
}
