package com.sz.qzxkj.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/** 管理员表
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Data
public class UserInfo implements Serializable {

    private Integer id;
    /* 密码 */
    private String password;
    /** 名字 */
    private String username;


}
