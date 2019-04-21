package com.sz.qzxkj.common.base.entity;

import com.sz.qzxkj.common.constant.DataBaseConstant;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
public abstract class AbstractEntity<ID> {

    public long currentPage;
    public long pageSize = DataBaseConstant.PAGE_SIZE;

    public abstract ID getId();

    public abstract void setId(ID id);

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
