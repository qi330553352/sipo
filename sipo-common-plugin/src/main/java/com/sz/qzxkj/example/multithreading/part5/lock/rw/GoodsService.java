package com.sz.qzxkj.example.multithreading.part5.lock.rw;

/** 商品服务接口
 * 创 建 时 间: 2019/5/7
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public interface GoodsService {

    /**
     * 获得商品信息
     * @return
     */
    GoodsInfo getNum();

    /**
     * 设置商品的数量
     * @param number
     */
    void setNum(int number);
}
