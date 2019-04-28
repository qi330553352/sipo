package com.sz.qzxkj.utils;

import com.alibaba.fastjson.JSON;
import com.sz.qzxkj.enumeration.RetEnum;
import com.sz.qzxkj.exception.BeamException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** 渲染工具类
 * 创 建 时 间: 2019/3/26
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
public class RenderUtil {

    /**
     * 渲染json对象
     */
    public static void renderJson(HttpServletResponse response, Object jsonObject) {
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(jsonObject));
        } catch (IOException e) {
            throw new BeamException(RetEnum.WRITE_ERROR);
        }
    }
}
