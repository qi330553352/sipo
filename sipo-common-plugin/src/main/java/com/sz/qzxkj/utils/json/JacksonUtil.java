package com.sz.qzxkj.utils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * 创 建 时 间: 2019/4/28
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class JacksonUtil {

    private static ObjectMapper MAPPER = new ObjectMapper();

    // 将对象转换成json字符串
    public static String objectToJson(Object obj){
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 将json数据转换成pojo对象
    public static <T> T jsonToObject(String json,Class<T> beanType){
        try {
            return MAPPER.readValue(json, beanType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 将json数据转换成pojo对象list
    public static <T> List<T> jsonToList(String json, Class<T> beanType){
        JavaType javaType=MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try{
            return MAPPER.readValue(json, javaType);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
