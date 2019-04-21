package com.sz.qzxkj.common.utils;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/** 资源文件相关的操作类
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
public class ResKit {

    /**
     * @Description 批量获取ClassPath下的资源文件
     * @author fengshuonan
     */
    public static Resource[] getClassPathResources(String pattern) {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            return resolver.getResources(pattern);
        } catch (IOException e) {
            throw new RuntimeException("加载resource文件时,找不到文件,所找文件为：" + pattern);
        }
    }

    /**
     * @Description 批量获取ClassPath下的资源文件
     * @author fengshuonan
     */
    public static String getClassPathFile(String file) {
        //return ResKit.class.getClassLoader().getResource(file).getPath();
        return Thread.currentThread().getContextClassLoader().getResource(file).getPath();
    }
}
