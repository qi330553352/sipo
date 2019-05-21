package com.sz.qzxkj;

import com.sz.qzxkj.entity.DepartmentInfo;

import java.util.Vector;

/**
 * 创 建 时 间: 2019/5/11
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class Gc {


    public static void main(String[] args){
        Vector v=new Vector();
        for(int i=0;i<25;i++)
            v.add(new byte[1*1024*1024]);
    }
}
