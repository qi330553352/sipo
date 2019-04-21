package com.sz.qzxkj.common.utils;

import com.sz.qzxkj.common.enumeration.RetEnum;
import com.sz.qzxkj.common.exception.BeamException;
import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
@Log4j2
public class FileUtil {

    /**
     * NIO way
     */
    public static byte[] toByteArray(String filename) {

        File f = new File(filename);
        if (!f.exists()) {
            log.error("文件未找到！" + filename);
            throw new BeamException(RetEnum.FILE_NOT_FOUND);
        }
        FileChannel channel = null;
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(f);
            channel = fs.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
            while ((channel.read(byteBuffer)) > 0) {
                // do nothing
                // System.out.println("reading");
            }
            return byteBuffer.array();
        } catch (IOException e) {
            throw new BeamException(RetEnum.FILE_READING_ERROR);
        } finally {
            try {
                channel.close();
            } catch (IOException e) {
                throw new BeamException(RetEnum.FILE_READING_ERROR);
            }
            try {
                fs.close();
            } catch (IOException e) {
                throw new BeamException(RetEnum.FILE_READING_ERROR);
            }
        }
    }

    /**
     * 删除目录
     *
     * @author fengshuonan
     * @Date 2017/10/30 下午4:15
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    /**
     * 复制文件
     *
     * @author huangshuai
     * @Date 2018/08/21 09:26
     * file 被复制文件
     * tofile 复制文件
     */
    public static void copy(File src, File dst) throws Exception {
        int BUFFER_SIZE = 4096;
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                out = null;
            }
        }
    }

}
