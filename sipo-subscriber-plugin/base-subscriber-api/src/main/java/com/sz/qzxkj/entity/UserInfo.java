package com.sz.qzxkj.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
@ToString
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<RoleInfo> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleInfo> roles) {
        this.roles = roles;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getDepartmentInfoId() {
        return departmentInfoId;
    }

    public void setDepartmentInfoId(Integer departmentInfoId) {
        this.departmentInfoId = departmentInfoId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
