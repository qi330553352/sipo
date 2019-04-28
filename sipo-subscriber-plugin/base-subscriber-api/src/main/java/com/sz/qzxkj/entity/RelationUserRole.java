package com.sz.qzxkj.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 创 建 时 间: 2019/3/27
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@ToString
public class RelationUserRole implements Serializable{

    private Integer id;
    private Integer userInfoId;
    private Integer roleInfoId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Integer userInfoId) {
        this.userInfoId = userInfoId;
    }

    public Integer getRoleInfoId() {
        return roleInfoId;
    }

    public void setRoleInfoId(Integer roleInfoId) {
        this.roleInfoId = roleInfoId;
    }
}
