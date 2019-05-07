package com.sz.qzxkj.example.multithreading.part5.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 使用Lock的范例
 * 创 建 时 间: 2019/5/7
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class LockCase {

    private Lock lock = new ReentrantLock();
    private int age = 100000;

    private static class TestThread extends Thread{
        private LockCase lockCase;

        public TestThread(LockCase lockCase,String name) {
            super(name);
            this.lockCase = lockCase;
        }

        @Override
        public void run() {
            for(int i=0;i<100000;i++){
                lockCase.test();
            }
            System.out.println(Thread.currentThread().getName()+" age "+ lockCase.getAge());
        }
    }

    private void test() {
        lock.lock();
        try{
            age++;
        }finally {
            lock.unlock();
        }
    }

    private void test2() {
        lock.lock();
        try{
            age--;
        }finally {
            lock.unlock();
        }
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        LockCase lockCase = new LockCase();
        Thread endThread = new TestThread(lockCase,"endThread");
        endThread.start();
        for(int i=0;i<100000;i++){
            lockCase.test2();
        }
        System.out.println(Thread.currentThread().getName()+" age "+ lockCase.getAge());
    }
}
