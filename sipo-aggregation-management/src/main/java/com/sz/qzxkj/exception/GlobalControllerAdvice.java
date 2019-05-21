package com.sz.qzxkj.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/** 全局异常处理类
 * 创 建 时 间: 2019/5/16
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> exceptionHandler(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("msg",e.getMessage());
        map.put("code","500");
        return map;
    }

    @ExceptionHandler(value = BeamException.class)
    public Map<String,Object> exceptionHandler(BeamException e){
        Map<String,Object> map = new HashMap<>();
        map.put("msg",e.getMessage());
        map.put("code",e.getCode());
        return map;
    }
}
