package com.sz.qzxkj.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 创 建 时 间: 2019/7/21
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Data
@Entity
@Table(name = "sys_users_info")
public class UsersInfo implements Serializable {

    @Id
    private Integer id;
    @Column(length = 32)
    private String userName;
    private String password;
    private Integer age;
    private Date createTime;

}
