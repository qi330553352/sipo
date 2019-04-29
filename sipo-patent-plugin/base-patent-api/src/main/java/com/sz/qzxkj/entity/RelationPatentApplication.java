package com.sz.qzxkj.entity;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/** 申请号 与 申请（专利权）人 关系表
 * 创 建 时 间: 2019/3/21
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
@Entity
@ToString
public class RelationPatentApplication implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    /* 申请（专利权）人ID */
    private Integer applicantInfoId;
    /* 专利信息ID */
    private Integer patentInfoId;
    /* 申请号 */
    private String patentno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplicantInfoId() {
        return applicantInfoId;
    }

    public void setApplicantInfoId(Integer applicantInfoId) {
        this.applicantInfoId = applicantInfoId;
    }

    public Integer getPatentInfoId() {
        return patentInfoId;
    }

    public void setPatentInfoId(Integer patentInfoId) {
        this.patentInfoId = patentInfoId;
    }

    public String getPatentno() {
        return patentno;
    }

    public void setPatentno(String patentno) {
        this.patentno = patentno;
    }
}
