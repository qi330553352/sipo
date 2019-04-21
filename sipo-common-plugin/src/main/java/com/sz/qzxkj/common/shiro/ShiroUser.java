package com.sz.qzxkj.common.shiro;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
@Data
public class ShiroUser implements Serializable{

    private Integer id;
    /* 头像 */
    private String avatar;
    /* 账号 */
    private String account;
    /* 名字 */
    private String name;

    private Integer deptId;      // 部门id

    private List<Integer> roleList; // 角色集

    private String deptName;        // 部门名称

    private List<String> roleNames; // 角色名称集
}
