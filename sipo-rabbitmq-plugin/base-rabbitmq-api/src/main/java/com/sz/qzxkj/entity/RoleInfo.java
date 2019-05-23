package com.sz.qzxkj.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Data
public class RoleInfo implements Serializable {

    private Integer id;
    private Set<UserInfo> users = new HashSet<>();
    private Set<PermissionInfo> permissions = new HashSet<>();

    // 角色名称
    private String roleName;
    // 备注
    private String remark;

}
