package com.sz.qzxkj.core.common.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 创 建 时 间: 2019/4/12
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Data
@NoArgsConstructor
public class QueryPageVO<T> implements Serializable {

    private Integer page;
    private Integer pageSize;
    private Integer total;
    private T data;


}
