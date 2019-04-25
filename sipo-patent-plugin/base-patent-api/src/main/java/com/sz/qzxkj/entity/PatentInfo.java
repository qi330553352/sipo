package com.sz.qzxkj.entity;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

/** 专利信息(不易变的属性)
 * 创 建 时 间: 2019/3/21
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
@Data
public class PatentInfo implements Serializable{

    /* id */
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

        @Getter
        private String messages;

        PatentTypeEnum(String messages) {
            this.messages=messages;
        }
    }
}
