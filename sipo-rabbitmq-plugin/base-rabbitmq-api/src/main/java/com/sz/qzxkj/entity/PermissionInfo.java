package com.sz.qzxkj.entity;

import lombok.Data;

import java.io.Serializable;

/** 权限
 * 创 建 时 间: 2019/3/26
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Data
public class PermissionInfo implements Serializable {

    private Integer id;
    private String permission;
    private RoleInfo role;
}
