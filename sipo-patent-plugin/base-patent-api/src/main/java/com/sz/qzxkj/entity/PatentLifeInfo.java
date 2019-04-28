package com.sz.qzxkj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/** 专利记录
 * 创 建 时 间: 2019/3/22
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
@ToString
public class PatentLifeInfo implements Serializable {

    private Integer id;
    private Integer patentInfoId;
    /* 备注 */
    private String remarks;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatentInfoId() {
        return patentInfoId;
    }

    public void setPatentInfoId(Integer patentInfoId) {
        this.patentInfoId = patentInfoId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
