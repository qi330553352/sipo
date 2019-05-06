package com.sz.qzxkj.example.multithreading.part1;

/** 类说明：中断线程 Runnable
 * Thread.currentThread().isInterrupted()
 * 创 建 时 间: 2019/5/6
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class EndRunnable {

    /**
     * Thread.currentThread() 会将当前调用线程给返回回来
     */
    private static class UseRunnable implements Runnable{

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName()+" am extends Thread");
            }
            System.out.println(Thread.currentThread().getName()+" am extends Thread: "+Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseRunnable useRunnable = new UseRunnable();
        Thread endThread = new Thread(useRunnable,"endThread");
        endThread.start();
        Thread.sleep(20);
        endThread.interrupt();
    }
}
