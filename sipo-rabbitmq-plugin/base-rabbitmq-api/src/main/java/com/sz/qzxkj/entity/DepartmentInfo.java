package com.sz.qzxkj.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 部门信息
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Data
public class DepartmentInfo implements Serializable{

    private Integer id;
    // 上级部门ID，一级部门:0
    private Integer parentId;
    private Set<DepartmentInfo> children = new HashSet<>();

    // 部门名称
    private String departName;
    // 排序
    private Integer idx;
}
