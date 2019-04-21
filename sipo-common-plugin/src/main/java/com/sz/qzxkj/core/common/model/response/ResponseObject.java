package com.sz.qzxkj.core.common.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 创 建 时 间: 2019/4/12
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseObject<T> implements Serializable {

    private String msg;
    private String code;
    private List<T> datas;
    private String bizCode;
    private T data;

    public static <T> ResponseObject ok(T data, String msg) {
        ResponseObject<T> rep = new ResponseObject<>();
        rep.setMsg(msg);
        rep.setCode("200");
        rep.setData(data);
        return rep;
    }

    public static <T> ResponseObject error(T data, String msg) {
        ResponseObject<T> rep = new ResponseObject<>();
        rep.setMsg(msg);
        rep.setCode("500");
        rep.setData(data);
        return rep;
    }
}
