package com.sz.qzxkj.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 创 建 时 间: 2019/3/28
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class CryptographyUtil {

    /**
     * Md5加密
     * @param str 要加密的字符串
     * @param salt 盐值
     * @return 加密后的字符串
     * @author qixin
     */
    public static String md5(String str,String salt){
        return new Md5Hash(str,salt).toString();
    }

    public static void main(String[] args) {
        String password="123456";
        System.out.println("Md5加密："+CryptographyUtil.md5(password, "123456"));
    }
}
