package com.sz.qzxkj.common.utils;

import javax.servlet.http.HttpSession;

/** 非Controller中获取当前session的工具类
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
public class HttpSessionHolder {

    private static ThreadLocal<HttpSession> tl = new ThreadLocal<>();

    public static void put(HttpSession s) {
        tl.set(s);
    }

    public static HttpSession get() {
        return tl.get();
    }

    public static void remove() {
        tl.remove();
    }
}
