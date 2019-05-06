/**类说明：并发工具类（fork/join）-分而治之
 * 创 建 时 间: 2019/5/6
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
package com.sz.qzxkj.example.multithreading.part3.forkjoin;
/* 一、使用Fork/Join相关的类和使用的标准范式
    ForkJoinTask / ForkJoinPool
        RecursiveTask<V>：计算任务有返回结果
        RecursiveAction：计算任务没有返回结果
*/