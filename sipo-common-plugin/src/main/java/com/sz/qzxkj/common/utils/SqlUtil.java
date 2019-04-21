package com.sz.qzxkj.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
public class SqlUtil {
    /**
     * @Description 根据集合的大小，输出相应个数"?"
     * @author fengshuonan
     */
    public static String parse(List<?> list) {
        String str = "";
        if (list != null && list.size() > 0) {
            str = str + "?";
            for (int i = 1; i < list.size(); i++) {
                str = str + ",?";
            }
        }
        return str;
    }

    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(2);
        System.out.println(parse(arrayList));
    }
}
