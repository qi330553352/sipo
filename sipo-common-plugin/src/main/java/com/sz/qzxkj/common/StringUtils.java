package com.sz.qzxkj.common;

import java.util.UUID;

/**
 * 创 建 时 间: 2019/4/21
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class StringUtils extends org.springframework.util.StringUtils {

    public static String localUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }
}
