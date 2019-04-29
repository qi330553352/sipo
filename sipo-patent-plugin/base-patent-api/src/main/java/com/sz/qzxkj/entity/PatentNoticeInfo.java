package com.sz.qzxkj.entity;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/** 专利公告记录
 * 创 建 时 间: 2019/4/5
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Entity
@ToString
public class PatentNoticeInfo implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    /* 标题 */
    private String noticeTile;
    /* 副标题 */
    private String subheading;
    /* 文件名称 */
    private String fileName;
    /* 总记录数 */
    private Integer total;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoticeTile() {
        return noticeTile;
    }

    public void setNoticeTile(String noticeTile) {
        this.noticeTile = noticeTile;
    }

    public String getSubheading() {
        return subheading;
    }

    public void setSubheading(String subheading) {
        this.subheading = subheading;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
