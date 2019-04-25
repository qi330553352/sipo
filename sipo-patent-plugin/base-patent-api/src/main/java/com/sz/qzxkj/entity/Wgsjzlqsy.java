package com.sz.qzxkj.entity;

import lombok.Data;

/**
 * 创 建 时 间: 2019/4/4
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Data
public class Wgsjzlqsy {

    private Integer id;
    /*主分类号*/
    private String flh;
    /* 授权公告号 */
    private String sqggh;
    private String sqgghv;
    /* 申请号 */
    private String sqh;
    private String sqhv;
    /* 申请日 */
    private String sqrtime;
    private String sqrtimev;
    /* 授权公告日 */
    private String sqggr;
    private String sqggrv;
    /*优先权数据*/
    private String yxqsj;
    private String yxqsjv;
    /*分案原申请数据*/
    private String faysqsj;
    private String faysqsjv;
    /* 专利权人 */
    private String zlqr;
    private String zlqrv;
    /* 地址 */
    private String dz;
    /* 设计人 */
    private String sjr;
    private String sjrv;
    /* 专利代理机构 */
    private String zldljg;
    private String zldljgv;
    /* 使用外观设计的产品名称 */
    private String mc;
    private String mcv;
}
