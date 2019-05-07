package com.sz.qzxkj.example.multithreading.part6;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;

/**定时任务工作类
 * 创 建 时 间: 2019/5/7
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class ScheduleWorker implements Runnable{
    public final static int Normal = 0;//普通任务类型
    public final static int HasException = -1;//会抛出异常的任务类型
    public final static int ProcessException = 1;//抛出异常但会捕捉的任务类型
    public static SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int taskType;

    public ScheduleWorker(int taskType) {
        this.taskType = taskType;
    }

    @Override
    public void run() {
        if(taskType==HasException){
            System.out.println(formater.format(new Date())+" Exception be made");
            throw new RuntimeException("ExceptionHappen");
        }else if(taskType==ProcessException){
            try{
                System.out.println(formater.format(new Date())+" Exception be made");
                throw new RuntimeException("ExceptionHappen");
            }catch (Exception e){
                System.out.println("We catch Excepton!");
            }
        }else {
            System.out.println(formater.format(new Date())+" Normal ... ");
        }
    }
}
