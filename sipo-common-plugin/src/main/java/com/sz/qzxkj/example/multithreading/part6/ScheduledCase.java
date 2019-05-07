package com.sz.qzxkj.example.multithreading.part6;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**执行我们的定时任务
 * 创 建 时 间: 2019/5/7
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class ScheduledCase {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor schedule = new ScheduledThreadPoolExecutor(1);
        //只执行一次的定时任务
        schedule.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(" the task run once!");
            }
        },3000, TimeUnit.MICROSECONDS);

    }
}
