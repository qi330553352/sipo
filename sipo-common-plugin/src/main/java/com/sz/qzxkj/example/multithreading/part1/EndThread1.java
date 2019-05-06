package com.sz.qzxkj.example.multithreading.part1;

/** 类说明：如何停止线程
 * interrupt()
 * isInterrupted()
 * interrupted()
 * 创 建 时 间: 2019/5/6
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class EndThread1 {

    private static class UseThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseThread useThread = new UseThread();
        useThread.start();
        useThread.stop(); //强制地终结线程，无法保证线程资源得到正常释放
        useThread.suspend();//线程挂起（让线程进入睡眠状态）	资源不会释放，会造成死锁
        useThread.interrupt();//中断线程	（不会中断线程，只是将中断标识位设置为true）
        useThread.isInterrupted();//检查线程是否中断
        Thread.interrupted();//检查线程是否中断，并且将线程中断标识位改为 false
        useThread.wait();//线程等待
        useThread.notify();//通知线程
        useThread.notifyAll();//通知所有线程
        useThread.yield();//让当前线程让出CPU时间(并不代表线程进入了睡眠)，OS依然可以选中当前线程
        useThread.join();//当前线程执行完成后，调用了join方法的线程才会执行下去
        useThread.setPriority(1); //设置线程的优先级，但某些OS会忽略此设置  此方法不建议使用应考虑别方法设置线程优先级
        useThread.setDaemon(true); //1、设置此线程为守护线程,在守护线程中 finally 代码块中的代码不一定会被执行
        //2、守护线程为支持型线程（程序后台调度作支持型工作）；垃圾回收线程为守护线程，当程序中的非守护型线程执行完后程序才会终止；
        //3、设置为守护线程一定要在start方法之前设置setDaemon(true)才会启作用
    }
}
