package com.sz.qzxkj.common.support;

/** 一些通用的函数
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
public class ObjectKit {

    /**
     * 比较两个对象是否相等。<br>
     * 相同的条件有两个，满足其一即可：<br>
     * 1. obj1 == null && obj2 == null; 2. obj1.equals(obj2)
     *
     * @param obj1 对象1
     * @param obj2 对象2
     * @return 是否相等
     */
    public static boolean equals(Object obj1, Object obj2) {
        return (obj1 != null) ? (obj1.equals(obj2)) : (obj2 == null);
    }

}
