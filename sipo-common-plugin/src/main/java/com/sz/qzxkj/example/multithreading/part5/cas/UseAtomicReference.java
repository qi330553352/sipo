package com.sz.qzxkj.example.multithreading.part5.cas;

import java.util.concurrent.atomic.AtomicReference;

/**引用类型的原子操作
 * 创 建 时 间: 2019/5/7
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class UseAtomicReference {

    static AtomicReference<UserInfo> atomicUser = new AtomicReference<>();

    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo("qixin",18);
        atomicUser.set(userInfo);
        UserInfo updateUser = new UserInfo("qixin1",19);
        atomicUser.compareAndSet(userInfo,updateUser);
        System.out.println(atomicUser.get().getName());
        System.out.println(atomicUser.get().getAge());
        System.out.println(userInfo.getName());
        System.out.println(userInfo.getAge());
    }

    static class UserInfo{
        private String name;
        private int age;

        public UserInfo() {
        }

        public UserInfo(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
