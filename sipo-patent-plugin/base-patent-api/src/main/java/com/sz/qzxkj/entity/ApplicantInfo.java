package com.sz.qzxkj.entity;

import lombok.ToString;

import java.io.Serializable;

/** 申请（专利权）人 信息
 * 创 建 时 间: 2019/3/21
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
@ToString
public class ApplicantInfo implements Serializable {

    private Integer id;
    /* 申请（专利权）人 */
    private String applicationName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
}
