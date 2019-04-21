package com.sz.qzxkj.common.utils;

import lombok.extern.log4j.Log4j2;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/** 反射的 Utils 函数集合 提供访问私有变量, 获取泛型类型 Class, 提取集合中元素属性等 Utils 函数
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
@Log4j2
public class ReflectionUtils {

    /**
     * 通过反射, 获得定义 Class 时声明的父类的泛型参数的类型 如: public EmployeeDao extends
     * BaseDao<Employee, String>
     *
     * @param clazz
     * @param index
     * @return
     */
    public static Class<?> getSuperClassGenricType(Class<?> clazz, int index) {
        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            log.info(clazz.getSimpleName() + "'s superclass not ParameterizedType");
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            log.info("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: "
                    + params.length);
            return Object.class;
        }

        if (!(params[index] instanceof Class)) {
            log.info(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
            return Object.class;
        }

        return (Class<?>) params[index];
    }

    /**
     * 通过反射, 获得 Class 定义中声明的父类的泛型参数类型 如:
     *
     * @param <T>
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getSuperGenericType(Class<?> clazz) {
        return (Class<T>) getSuperClassGenricType(clazz, 0);
    }

}
