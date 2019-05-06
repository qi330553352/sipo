package com.sz.qzxkj.example.multithreading.part4.tranfer.service;

import com.sz.qzxkj.example.multithreading.part4.tranfer.UserAccount;

/**类说明：不会产生死锁的安全转账
 * 创 建 时 间: 2019/5/6
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class SafeOperate implements ITransfer {

    private static Object tieLock = new Object();
    @Override
    public void transfer(UserAccount from, UserAccount to, int amount) throws InterruptedException {
        int fromHash = System.identityHashCode(from);
        int toHash = System.identityHashCode(to);

        if(fromHash<toHash){
            synchronized (from){
                System.out.println(Thread.currentThread().getName()+" get "+from.getName());
                Thread.sleep(100);
                synchronized (to){
                    System.out.println(Thread.currentThread().getName()+" get "+to.getName());
                    from.flyMoney(amount);
                    to.addMoney(amount);
                    System.out.println(from);
                    System.out.println(to);
                }
            }
        }else if(toHash<fromHash){
            synchronized (to){
                System.out.println(Thread.currentThread().getName()+" get"+to.getName());
                Thread.sleep(100);
                synchronized (from){
                    System.out.println(Thread.currentThread().getName()+" get"+from.getName());
                    from.flyMoney(amount);
                    to.addMoney(amount);
                    System.out.println(from);
                    System.out.println(to);
                }
            }
        }else{
            synchronized (tieLock){
                synchronized (from){
                    synchronized (to){
                        from.flyMoney(amount);
                        to.addMoney(amount);
                    }
                }
            }
        }
    }
}
