package com.sz.qzxkj.utils.poi;

import lombok.extern.log4j.Log4j2;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 创 建 时 间: 2019/4/21
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Log4j2
public class ExcelUtil {
    public static Integer CREATE_ROW_NUMBER = 0;

    public ExcelUtil() {
        CREATE_ROW_NUMBER = 4;
    }

    /**
     * 文件导出
     * @param fileName 文件、标题名 (*不加文件后缀)
     * @param headers 表头
     * @param withProperties 数据属性名称 (*与表头顺序一至)
     * @param dataLists 数据 (*别名与数据属性一至)
     * @param response
     * @author qixin
     */
    public static void export(String fileName, String[] headers, String[] withProperties, List<Map<String,Object>> dataLists, HttpServletResponse response){

        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet("Sheet1");
        sheet.setDefaultColumnWidth(3*sheet.getDefaultColumnWidth());

        fitTitle(book, sheet, fileName, headers.length-1);  //设置标题
        fitHeader(book, sheet, headers);                     //设置表头
        fitContent(book, sheet, withProperties, dataLists);  //设置内容
        StreamKit.fitStream(fileName, book, response);                 //设置输出流
    }

    /**
     * 文件导出
     * @param fileName 文件、标题名 (*不加文件后缀)
     * @param headers 表头
     * @param withProperties 数据属性名称 (*与表头顺序一至)
     * @param dataLists 数据 (*别名与数据属性一至)
     * @param currentUser 当前用户
     * @param response
     * @author qixin
     */
    public void export(String fileName, String[] headers, String[] withProperties, List<Map<String,Object>> dataLists, String currentUser, HttpServletResponse response){

        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet("Sheet1");
        sheet.setDefaultColumnWidth(2*sheet.getDefaultColumnWidth());

        InstallFit.fitTitle(book, sheet, fileName, headers.length-1, currentUser);  //设置标题
        InstallFit.fitHeader(book, sheet, headers);                     //设置表头
        InstallFit.fitContent(book, sheet, withProperties, dataLists);  //设置内容
        StreamKit.fitStream(fileName, book, response);                 //设置输出流
    }

    /**
     * 文件导出
     * @param fileName 文件、标题名 (*不加文件后缀)
     * @param headers 表头
     * @param treeMapList 自定义表格上面信息
     * @param treeMapData 自定义表格上面信息数据
     * @param withProperties 数据属性名称 (*与表头顺序一至)
     * @param dataLists 数据 (*别名与数据属性一至)
     * @param statistics 统计信息 (如：共%s种商品，合计拣货商品价值：%s 【默认合计最后一列数据】)
     * @param remarks 备注、说明
     * @param response 响应请求
     * @author qixin
     */
    public void export(String fileName, String[] headers, List<LinkedHashMap<String,String>> treeMapList, Map<String,Object> treeMapData, String[] withProperties, List<Map<String,Object>> dataLists, String statistics, String[] remarks, HttpServletResponse response){
        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet("Sheet1");
        sheet.setDefaultColumnWidth(2*sheet.getDefaultColumnWidth());

        InstallFit.fitTitle(book, sheet, fileName, headers.length-1);  //设置标题
        InstallFit.fitInfos(book,sheet,treeMapList,treeMapData);        //设置信息
        InstallFit.fitHeader(book, sheet, headers);                     //设置表头
        InstallFit.fitContent(book, sheet, withProperties, dataLists,statistics);  //设置内容
        InstallFit.fitRemarks(sheet,remarks);                           //设置备注、说明
        StreamKit.fitStream(fileName, book, response);                 //设置输出流
    }


    /**
     * 设置数据内容样式、内容等
     * @param book
     * @param sheet
     * @param withProperties 数据属性名称
     * @param dataLists 数据
     * @author qixin
     */
    private static void fitContent(HSSFWorkbook book, HSSFSheet sheet, String[] withProperties, List<Map<String,Object>> dataLists) {
        CreationHelper ch = book.getCreationHelper();
        CellStyle dateStyle = book.createCellStyle();
        dateStyle = CellStyleKit.setDefaultCellStyle((HSSFCellStyle) dateStyle);
        dateStyle.setDataFormat(ch.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));

        HSSFFont dataFont = book.createFont();
        dataFont.setFontHeightInPoints((short)11);
        dataFont.setFontName("SimSun");

        CellStyle dataCellStyle = book.createCellStyle();
        dataCellStyle = CellStyleKit.setDefaultCellStyle((HSSFCellStyle) dataCellStyle);
        dataCellStyle.setFont(dataFont);

        for (int i = 1; i < dataLists.size()+1; i++) {
            Row dataRow = sheet.createRow(4+i);
            for (int j = 0; j < withProperties.length; j++) {
                String attrName = withProperties[j];
                Map<String,Object> groovyRowResult = dataLists.get(i-1);
                Object value = groovyRowResult.get(attrName);
                if(value==null) groovyRowResult.put(attrName,"");
                Class<?> clazz = groovyRowResult.get(attrName).getClass();
                String simpleClassName = clazz.getSimpleName();

                Cell cell = dataRow.createCell(j);
                if(simpleClassName.equals("Timestamp"))
                    cell.setCellStyle(dateStyle);
                else
                    cell.setCellStyle(dataCellStyle);

                if (value==null)
                    cell.setCellValue("");
                else
                    cell.setCellValue(String.valueOf(value));
            }
        }
    }

    /**
     * 设置表头样式、内容等
     * @param book
     * @param sheet
     * @param headers 内容
     * @author qixin
     */
    private static void fitHeader(HSSFWorkbook book, HSSFSheet sheet, String[] headers) {
        HSSFFont headerFont = book.createFont();
        headerFont.setFontHeightInPoints((short)12);
        headerFont.setFontName("SimHei");
        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        CellStyle headerCellStyle = book.createCellStyle();
        headerCellStyle = CellStyleKit.setDefaultCellStyle((HSSFCellStyle) headerCellStyle);
        headerCellStyle.setFont(headerFont);

        Row header = sheet.createRow(4);
        for (int i = 0; i < headers.length; i++) {
            Cell headerCell = header.createCell(i);
            headerCell.setCellValue(headers[i]);
            headerCell.setCellStyle(headerCellStyle);
        }
    }

    /**
     * 设置标题样式、内容等
     * @param book
     * @param sheet
     * @param fileName 标题内容
     * @param witch 标题占几个单元格的宽度
     * @author qixin
     */
    private static void fitTitle(HSSFWorkbook book, HSSFSheet sheet, String fileName, int witch) {
        HSSFFont titleFont = book.createFont();
        titleFont.setFontHeightInPoints((short)24);
        titleFont.setFontName("SimHei");

        HSSFCellStyle titleCellStyle = book.createCellStyle();
        titleCellStyle = (HSSFCellStyle) CellStyleKit.setDefaultCellStyle(titleCellStyle);
        titleCellStyle.setFont(titleFont);

        Row row = sheet.createRow(0);
        Cell title = row.createCell(0);
        title.setCellValue(fileName);
        title.setCellStyle(titleCellStyle);
        CellRangeAddress rangeAddress = new CellRangeAddress(0,3,0,witch);
        sheet.addMergedRegion(rangeAddress);
        title = row.createCell(witch);
        title.setCellStyle(titleCellStyle);
        row = sheet.createRow(1);
        title = row.createCell(witch);
        title.setCellStyle(titleCellStyle);
        row = sheet.createRow(2);
        title = row.createCell(witch);
        title.setCellStyle(titleCellStyle);
        row = sheet.createRow(3);
        title = row.createCell(witch);
        title.setCellStyle(titleCellStyle);
    }
}
