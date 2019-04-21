package com.sz.qzxkj.common.base.entity;

import com.sz.qzxkj.common.constant.DataBaseConstant;

import java.util.Date;

/**
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
public abstract class DataEntity<ID> extends AbstractEntity<ID> {

    private Long createBy; // 创建者
    private Date createTime; // 创建日期
    private Long updateBy; // 更新者
    private Date updateTime; // 更新日期
    private Integer delFlag; // 删除标记（0：正常；1：删除 ）

    public DataEntity() {
        super();
        this.delFlag = DataBaseConstant.DEL_FLAG_NORMAL;
    }
}
