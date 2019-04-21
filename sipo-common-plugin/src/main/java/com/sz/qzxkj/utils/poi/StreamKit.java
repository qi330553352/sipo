package com.sz.qzxkj.utils.poi;

import com.sz.qzxkj.common.exception.RuntimeSystemException;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * 创 建 时 间: 2019/4/21
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Log4j2
public abstract class StreamKit {
    /**
     * 设置输出流
     * @param fileName 文件、标题名 (*不加文件后缀)
     * @param book 文件对象
     * @param response 响应
     * @author qixin
     */
    public static void fitStream(String fileName, Workbook book, HttpServletResponse response) {
        try {
            response.setHeader("Content-disposition", "attachment; filename="  + new String(fileName.getBytes("GB2312"), "ISO8859-1")+ ".xls");
        } catch (UnsupportedEncodingException e) {
            log.info("将文件名字符转换出错：", e);
            throw new RuntimeSystemException(e);
        }
        response.setContentType("application/vnd.ms-excel");
        try {
            OutputStream out = response.getOutputStream();
            book.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
            log.info("文件输出流异常：",e);
            throw new RuntimeSystemException(e);
        }
    }
}
