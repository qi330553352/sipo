package com.sz.qzxkj.utils.poi;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 * 创 建 时 间: 2019/4/21
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public abstract class CellStyleKit {
    /**
     * 设置默认的单元格样式(居右、黑色边框)
     * @param style 样式
     * @author qixin
     */
    public static CellStyle rightCellStyle(HSSFCellStyle style) {
        style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);     //居右
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  //上下居中

        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());    //边框颜色

        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        return style;
    }

    /**
     * 设置默认的单元格样式(剧中、黑色边框)
     * @param style 样式
     * @author qixin
     */
    public static CellStyle setDefaultCellStyle(HSSFCellStyle style) {
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);     //左右居中
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  //上下居中

        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());    //边框颜色

        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        return style;
    }

    /**
     * 设置默认的单元格样式(左右、上下 居中)
     * @param style 样式
     * @author qixin
     */
    public static CellStyle setCellStyle(HSSFCellStyle style) {
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);     //左右居中
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  //上下居中
        return style;
    }
}
