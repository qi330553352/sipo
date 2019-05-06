package com.sz.qzxkj.example.multithreading.part1;

/** 类说明：如何中断线程 Thread
 * 创 建 时 间: 2019/5/6
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class EndThread {
    private static class UseThread extends Thread {
        UseThread(String name){
            super(name);
        }

        @Override
        public void run() {
            while (!isInterrupted()){
                System.out.println(Thread.currentThread().getName()+" am extends Thread");
            }
            System.out.println(Thread.currentThread().getName()+" am extends Thread: "+isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new UseThread("endThread");
        endThread.start();
        Thread.sleep(20);
        endThread.interrupt(); //中断线程
    }
}
