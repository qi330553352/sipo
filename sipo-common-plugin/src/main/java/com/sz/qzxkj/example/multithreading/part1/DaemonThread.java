package com.sz.qzxkj.example.multithreading.part1;

/** 类说明：守护线程 setDaemon
 * 守护线程 finally 代码块中的代码不一定会被执行
 * 创 建 时 间: 2019/5/6
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class DaemonThread {

    private static class UseThread extends Thread {
        @Override
        public void run() {
            try{
                while (!isInterrupted()){
                    System.out.println(Thread.currentThread().getName()+" I am extends Thread "+Thread.currentThread().isInterrupted());
                }
            }finally {
                System.out.println("... ... finally ");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseThread useThread = new UseThread();
        //useThread.setDaemon(true);
        useThread.start();
        Thread.sleep(5);
        //useThread.interrupt();
    }

}
