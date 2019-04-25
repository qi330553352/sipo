package com.sz.qzxkj.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/** 专利公告记录
 * 创 建 时 间: 2019/4/5
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Data
public class PatentNoticeInfo implements Serializable{

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
}
