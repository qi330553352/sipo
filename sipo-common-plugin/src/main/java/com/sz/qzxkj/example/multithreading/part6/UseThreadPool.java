package com.sz.qzxkj.example.multithreading.part6;

import com.sz.qzxkj.example.multithreading.tools.SleepTools;

import java.util.Random;
import java.util.concurrent.*;

/**线程池的使用范例
 * 创 建 时 间: 2019/5/7
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class UseThreadPool {
    static class Worker implements Runnable{
        private String taskName;
        private Random r = new Random();

        public Worker(String taskName) {
            this.taskName = taskName;
        }

        public String getTaskName() {
            return taskName;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" process the task: "+taskName);
            SleepTools.ms(r.nextInt(100)*5);
        }
    }

    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(2,4,3, TimeUnit.SECONDS,new ArrayBlockingQueue<>(3),new ThreadPoolExecutor.DiscardOldestPolicy());
        for(int i=0;i<=6;i++){
            Worker worker = new Worker("worker"+i);
            System.out.println("A new task has been added:"+worker.getTaskName());
            threadPool.execute(worker);
        }
        threadPool.shutdown();
    }
}
