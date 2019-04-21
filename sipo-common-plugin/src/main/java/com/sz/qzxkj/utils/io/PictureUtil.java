package com.sz.qzxkj.utils.io;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.sz.qzxkj.common.StringUtils;

import java.io.*;

/**
 * 创 建 时 间: 2019/4/21
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class PictureUtil {

    public static String file2byteString(String filePath){
        byte[] bytes = File2byte(filePath);
        return Base64.encode(bytes);
    }

    /**
     * 将字节字符串转换成指定格式的文件对象
     * @param byteString 字节字符串
     * @param picturePath 指定的文件名称
     * @param fileName 指定的文件后缀
     * @return 文件对象
     * @author qixin
     */
    public static String byteString2File(String byteString,String picturePath,String fileName){
        byte[] bytes = Base64.decode(byteString);
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = new File(picturePath,fileName);
        try {
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return file.getName();
    }

    /**
     * file 转byte[]
     *
     * @param filePath
     * @return
     */
    public static byte[] File2byte(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
    public static void main(String[] args) {
		/*String str = "D:\\20161022185620.png";
		String byteString = PictureUtil.file2byteString(str);
		System.out.println(byteString);*/
        String str = "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";
        PictureUtil.byteString2File(str,"D:\\", StringUtils.localUUID()+".png");
    }
}
