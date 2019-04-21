package com.sz.qzxkj.common.aop;

import com.sz.qzxkj.common.enumeration.RetEnum;
import com.sz.qzxkj.common.exception.BeamException;
import com.sz.qzxkj.common.utils.R;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/** 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
@Log4j2
public class BaseControllerExceptionHandler {

    /**
     * 拦截业务异常
     */
    @ResponseBody
    @ExceptionHandler(BeamException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object notFount(BeamException e) {
        log.error("业务异常:", e);
        return R.fail(e.getCode(), e.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     */
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object notFount(RuntimeException e) {
        log.error("运行时异常:", e);
        return R.fail(RetEnum.SERVER_EXCEPTION.getRet(), RetEnum.SERVER_EXCEPTION.getMsg());
    }

}
