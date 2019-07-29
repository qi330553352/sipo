package com.sz.qzxkj.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 创 建 时 间: 2019/7/29
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Data
public class FastDFSFile implements Serializable {

    private String name;
    private byte[] content;
    private String ext;
    private String md5;
    private String author;

    public FastDFSFile() {
    }

    public FastDFSFile(String fileName, byte[] file_buff, String ext) {
        this.name=fileName;
        this.content=file_buff;
        this.ext=ext;
    }
}
