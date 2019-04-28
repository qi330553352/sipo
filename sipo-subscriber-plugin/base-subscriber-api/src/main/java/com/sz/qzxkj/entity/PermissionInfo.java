package com.sz.qzxkj.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/** 权限
 * 创 建 时 间: 2019/3/26
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@ToString
public class PermissionInfo implements Serializable {

    private Integer id;
    private String permission;
    private RoleInfo role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public RoleInfo getRole() {
        return role;
    }

    public void setRole(RoleInfo role) {
        this.role = role;
    }
}
