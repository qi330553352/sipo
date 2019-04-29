package com.sz.qzxkj.entity;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/** 专利信息(不易变的属性)
 * 创 建 时 间: 2019/3/21
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
@Entity
@ToString
public class PatentInfo implements Serializable{

    /* id */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    /* 申请号 */
    private String patentno;
    /* 发明（设计）名称 */
    private String patentName;
    /* 专利类型 */
    private String patentType;
    /* 授权公告号 */
    private String notificationno;
    /* 授权公告日 */
    private Date notificationTime;
    /* 申请日 */
    private Date applyTime;
    /* 分类 */
    private String classification;


    public enum PatentTypeEnum {

        UNTREATED("未处理"),
        PUBLISH("发明公布");

        private String messages;

        PatentTypeEnum(String messages) {
            this.messages=messages;
        }

        public String getMessages() {
            return messages;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatentno() {
        return patentno;
    }

    public void setPatentno(String patentno) {
        this.patentno = patentno;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getPatentType() {
        return patentType;
    }

    public void setPatentType(String patentType) {
        this.patentType = patentType;
    }

    public String getNotificationno() {
        return notificationno;
    }

    public void setNotificationno(String notificationno) {
        this.notificationno = notificationno;
    }

    public Date getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(Date notificationTime) {
        this.notificationTime = notificationTime;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
