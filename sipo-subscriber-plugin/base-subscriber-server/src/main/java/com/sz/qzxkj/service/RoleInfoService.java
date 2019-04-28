package com.sz.qzxkj.service;

import com.sz.qzxkj.entity.RoleInfo;
import com.sz.qzxkj.feign.RoleInfoApi;
import com.sz.qzxkj.mapper.RoleInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Service
public class RoleInfoService implements RoleInfoApi {

    @Autowired
    private RoleInfoMapper mapper;


    @Override
    public RoleInfo findById(Integer roleId) {
        return null;
    }
}
