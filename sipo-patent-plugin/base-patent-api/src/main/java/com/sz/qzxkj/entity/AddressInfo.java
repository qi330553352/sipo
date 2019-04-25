package com.sz.qzxkj.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 创 建 时 间: 2019/4/5
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Data
public class AddressInfo implements Serializable {

    private Integer id;
    private String address;
    private String zipcode;
}
