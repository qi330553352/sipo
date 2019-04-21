package com.sz.qzxkj.common.exception;

/**
 * 创 建 时 间: 2019/4/21
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class RuntimeSystemException extends RuntimeException {

    public RuntimeSystemException(String message) {
        super(message);
    }

    public RuntimeSystemException(Throwable cause) {
        super(cause);
    }

    public RuntimeSystemException(String message, Throwable cause) {
        super(message, cause);
    }

}
