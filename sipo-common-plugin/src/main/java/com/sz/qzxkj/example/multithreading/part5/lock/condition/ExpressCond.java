package com.sz.qzxkj.example.multithreading.part5.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 创 建 时 间: 2019/5/7
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class ExpressCond {
    public final static String CITY = "ShangHai";
    /* 快递运输里程数 */
    private int km;
    /* 快递到达地点 */
    private String site;
    private Lock kmLock = new ReentrantLock();
    private Lock siteLock = new ReentrantLock();
    private Condition kmCond = kmLock.newCondition();
    private Condition siteCond = siteLock.newCondition();

    public ExpressCond() {
    }

    ExpressCond(int km, String site) {
        this.km = km;
        this.site = site;
    }
    /* 变化公里数，然后通知处于wait状态并需要处理公里数的线程进行业务处理 */
    public void changeKm() {
        kmLock.lock();
        try{
            this.km=101;
            kmCond.signal();//通知其他在锁上等待的线程
        }finally {
            kmLock.unlock();
        }
    }

    /* 变化地点，然后通知处于wait状态并需要处理地点的线程进行业务处理 */
    public void changeSite() {
        siteLock.lock();
        try{
            this.site="BeiJing";
            siteCond.signal();//通知其他在锁上等待的线程
        }finally {
            siteLock.unlock();
        }
    }
    /* 当快递的里程数大于100时更新数据库*/
    public void waitKm() {
        kmLock.lock();
        try{
            while (this.km<100){
                try{
                    kmCond.await();
                    System.out.println("check km thread["+Thread.currentThread().getName()+"] is be notify ");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }finally {
            kmLock.unlock();
        }
        System.out.println("this Km is "+this.km+" ,I will change db ");
    }

    /* 当快递到达目的地时通知用户 */
    public void waitSite() {
        siteLock.lock();
        try{
            while (this.site.equals(CITY)){
                try{
                    siteCond.await();
                    System.out.println("check site thread["+Thread.currentThread().getName()+"] is be notify ");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }finally {
            siteLock.unlock();
        }
        System.out.println("this Site is "+this.site+" ,I will change db ");
    }


    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
