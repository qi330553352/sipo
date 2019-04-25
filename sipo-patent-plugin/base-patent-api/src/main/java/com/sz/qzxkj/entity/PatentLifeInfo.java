package com.sz.qzxkj.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/** 专利记录
 * 创 建 时 间: 2019/3/22
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
@Data
public class PatentLifeInfo implements Serializable {

    private Integer id;
    private Integer patentInfoId;
    /* 备注 */
    private String remarks;
    private Date createTime;
}
