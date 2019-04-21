package com.sz.qzxkj.common.support.exception;

import com.sz.qzxkj.common.support.StrKit;

/** 工具类初始化异常
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
public class ToolBoxException extends RuntimeException{

    public ToolBoxException(Throwable e) {
        super(e.getMessage(), e);
    }

    public ToolBoxException(String message) {
        super(message);
    }

    public ToolBoxException(String message, Throwable cause) {
        super(message, cause);
    }

    public ToolBoxException(String messageTemplate, Object... params) {
        super(StrKit.format(messageTemplate, params));
    }

    public ToolBoxException(Throwable throwable, String messageTemplate, Object... params) {
        super(StrKit.format(messageTemplate, params), throwable);
    }
}
