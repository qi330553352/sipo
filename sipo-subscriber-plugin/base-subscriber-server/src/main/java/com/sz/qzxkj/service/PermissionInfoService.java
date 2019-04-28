package com.sz.qzxkj.service;

import com.sz.qzxkj.feign.PermissionInfoApi;
import com.sz.qzxkj.mapper.PermissionInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创 建 时 间: 2019/3/27
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Service
public class PermissionInfoService implements PermissionInfoApi {

    @Autowired
    private PermissionInfoMapper mapper;


}
