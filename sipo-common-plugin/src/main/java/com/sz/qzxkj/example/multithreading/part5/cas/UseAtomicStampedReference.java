package com.sz.qzxkj.example.multithreading.part5.cas;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicStampedReference;

/**带版本戳的原子操作类
 * 创 建 时 间: 2019/5/7
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class UseAtomicStampedReference {
    static AtomicStampedReference<String> asr = new AtomicStampedReference("qixin",0);

    public static void main(String[] args)throws InterruptedException {
        int oldStamp = asr.getStamp();//获得初始版本戳
        String oldReference = asr.getReference();
        System.out.println(oldStamp+"======"+oldReference);
        Thread rightStampThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+":当前的变量值 "+oldStamp+"======"+oldReference+asr.compareAndSet(oldReference,oldReference+"java",oldStamp,oldStamp+1));
            }
        });
        Thread errorStampThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String referenc = asr.getReference();//变量的最新值

                System.out.println(Thread.currentThread().getName()+":当前的变量值 "+oldStamp+"======"+oldReference+asr.compareAndSet(referenc,referenc+"C",oldStamp,oldStamp+1));
            }
        });
        rightStampThread.start();
        rightStampThread.join();
        errorStampThread.start();
        errorStampThread.join();
        System.out.println(asr.getReference()+"---"+asr.getStamp());
    }
}
