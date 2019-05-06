package com.sz.qzxkj.example.multithreading.part1;

/**  类说明：run方法中抛出了InterrputException异常的情况
 * 抛出 InterruptedException 后 isInterrupted() 会设置为false，但程序不会停止；
 * 应再次手动设置程序停止: interrupt();
 * 创 建 时 间: 2019/5/6
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class HasInterrputException {

    private static class UseThread extends Thread{
        UseThread(String name){
            super(name);
        }

        @Override
        public void run() {
            while (!isInterrupted()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()+" interrup flag is: "+isInterrupted());
                    interrupt();
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+" I am extends Thread");
            }
            System.out.println(Thread.currentThread().getName()+" interrup flag is: "+isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new UseThread("endThread");
        endThread.start();
        Thread.sleep(500);
        endThread.interrupt();
    }
}
