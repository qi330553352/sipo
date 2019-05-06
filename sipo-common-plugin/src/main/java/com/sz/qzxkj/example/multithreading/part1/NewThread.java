package com.sz.qzxkj.example.multithreading.part1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/** 类说明：新启线程的三种方式
 * 创 建 时 间: 2019/5/6
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class NewThread {

    private static class UseThread extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" am extendes Thread");
        }
    }

    private static class UseRunable implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" implements Runnable ");
        }
    }

    // 允许有返回值
    private static class UseCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName()+" implements Callable<String> ");
            return "CallResult";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        UseThread useThread = new UseThread();
        useThread.start();
        useThread.stop();
        useThread.suspend();

        UseRunable useRunable = new UseRunable();
        new Thread(useRunable).start();

        UseCallable useCallable = new UseCallable();
        FutureTask<String> futureTask = new FutureTask<>(useCallable);//包装
        new Thread(futureTask).start();
        System.out.println("Get UseCallable result:"+futureTask.get()); //拿结果
    }
}
