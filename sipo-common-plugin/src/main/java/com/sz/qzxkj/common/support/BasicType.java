package com.sz.qzxkj.common.support;

import java.util.HashMap;
import java.util.Map;

/** 基本变量类型的枚举
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
public enum BasicType {

    BYTE, SHORT, INT, INTEGER, LONG, DOUBLE, FLOAT, BOOLEAN, CHAR, CHARACTER, STRING;

    /**
     * 原始类型为Key，包装类型为Value，例如： int.class -> Integer.class.
     */
    public static final Map<Class<?>, Class<?>> wrapperPrimitiveMap = new HashMap<Class<?>, Class<?>>(8);

    /**
     * 包装类型为Key，原始类型为Value，例如： Integer.class -> int.class.
     */
    public static final Map<Class<?>, Class<?>> primitiveWrapperMap = new HashMap<Class<?>, Class<?>>(8);

    static {
        wrapperPrimitiveMap.put(Boolean.class, boolean.class);
        wrapperPrimitiveMap.put(Byte.class, byte.class);
        wrapperPrimitiveMap.put(Character.class, char.class);
        wrapperPrimitiveMap.put(Double.class, double.class);
        wrapperPrimitiveMap.put(Float.class, float.class);
        wrapperPrimitiveMap.put(Integer.class, int.class);
        wrapperPrimitiveMap.put(Long.class, long.class);
        wrapperPrimitiveMap.put(Short.class, short.class);

        for (Map.Entry<Class<?>, Class<?>> entry : wrapperPrimitiveMap.entrySet()) {
            primitiveWrapperMap.put(entry.getValue(), entry.getKey());
        }
    }
}
