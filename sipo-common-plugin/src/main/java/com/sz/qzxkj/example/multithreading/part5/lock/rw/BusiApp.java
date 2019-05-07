package com.sz.qzxkj.example.multithreading.part5.lock.rw;

import com.sz.qzxkj.example.multithreading.tools.SleepTools;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 创 建 时 间: 2019/5/7
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class BusiApp {
    /* 读写线程的比例 */
    static final int readWriteRatio = 10;
    /* 最少线程数 */
    static final int minthreadCount = 3;
    static CountDownLatch latch = new CountDownLatch(1);
    private static class GetThread implements Runnable{
        private GoodsService goodsService;

        public GetThread(GoodsService goodsService) {
            this.goodsService = goodsService;
        }

        @Override
        public void run() {
            try{
                latch.await();//让读写线程同时运行
            }catch (InterruptedException e){
            }
            long start = System.currentTimeMillis();
            for(int i=0;i<100;i++){
                goodsService.getNum();
            }
            System.out.println(Thread.currentThread().getName()+" 读取商品数据耗时："+(System.currentTimeMillis()-start)+"ms");
        }
    }
    private static class SetThread implements Runnable{
        private GoodsService goodsService;

        public SetThread(GoodsService goodsService) {
            this.goodsService = goodsService;
        }

        @Override
        public void run() {
            try{
                latch.await();//让读写线程同时运行
            }catch (InterruptedException e){
            }
            long start = System.currentTimeMillis();
            Random r = new Random();
            for(int i=0;i<10;i++){
                SleepTools.ms(5);
                goodsService.setNum(r.nextInt(10));
            }
            System.out.println(Thread.currentThread().getName()+
                    "写商品数据耗时:"+(System.currentTimeMillis()-start)+"ms------------");
        }
    }

    public static void main(String[] args) {
        GoodsInfo goodsInfo = new GoodsInfo("Cup",100000,10000);
//        GoodsService goodsService = new UseSyn(goodsInfo);
        GoodsService goodsService = new UseRwLock(goodsInfo);
        for(int i=0;i<minthreadCount;i++){
            Thread setT = new Thread(new SetThread(goodsService));
            for(int j=0;j<readWriteRatio;j++){
                Thread getT = new Thread(new GetThread(goodsService));
                getT.start();
            }
            setT.start();
        }
        latch.countDown();
    }
}
