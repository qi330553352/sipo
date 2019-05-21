package com.sz.qzxkj.exception;

import com.sz.qzxkj.enumeration.RetEnum;

/**
 * 创 建 时 间: 2019/3/26
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
public class BeamException extends RuntimeException {

    private Integer code;
    private String message;

    public BeamException(RetEnum retEnum) {
        this.code = retEnum.getRet();
        this.message = retEnum.getMsg();
    }

    public BeamException(String msg) {
        super(msg);
        this.message = msg;
    }

    public BeamException(String msg, Throwable e) {
        super(msg, e);
        this.message = msg;
    }

    public BeamException(String msg, int code, Throwable e) {
        super(msg, e);
        this.message = msg;
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
