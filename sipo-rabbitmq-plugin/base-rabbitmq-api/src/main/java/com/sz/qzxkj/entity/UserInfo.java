package com.sz.qzxkj.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
    private Set<RoleInfo> roles = new HashSet<>();

    /* 头像 */
    private String avatar;
    /* 账号 */
    private String account;
    /* 密码 */
    private String password;
    /* 验证码 */
    private String captcha;
    /* md5密码盐 */
    private String salt;

    /** 名字 */
    private String username;
    /** 部门ID */
    private Integer departmentInfoId;
    /** 生日 */
    private Date birthday;
    /** 性别（女 男）*/
    private String sex;
    /* 电子邮件*/
    private String email;

    /* 电话 */
    private String phoneno;
    /** 状态(启用  冻结  删除） */
    private String status;


}
