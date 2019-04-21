package com.sz.qzxkj.common.base.controller;

import com.sz.qzxkj.common.support.HttpKit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
public class BaseController {

    protected HttpServletRequest getHttpServletRequest() {
        return HttpKit.getRequest();
    }

    protected HttpServletResponse getHttpServletResponse() {
        return HttpKit.getResponse();
    }

    protected HttpSession getSession() {
        return HttpKit.getRequest().getSession();
    }

    protected HttpSession getSession(Boolean flag) {
        return HttpKit.getRequest().getSession(flag);
    }

    protected String getPara(String name) {
        return HttpKit.getRequest().getParameter(name);
    }

    protected void setAttr(String name, Object value) {
        HttpKit.getRequest().setAttribute(name, value);
    }

    protected Integer getSystemInvokCount() {
        return (Integer) this.getHttpServletRequest().getServletContext().getAttribute("systemCount");
    }



    /**
     * 包装一个list，让list增加额外属性
     */
//    protected Object warpObject(BaseControllerWarpper warpper) {
//        return warpper.warp();
//    }
}
