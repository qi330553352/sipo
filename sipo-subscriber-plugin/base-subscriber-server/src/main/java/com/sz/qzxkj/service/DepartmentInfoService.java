package com.sz.qzxkj.service;

import com.sz.qzxkj.entity.DepartmentInfo;
import com.sz.qzxkj.feign.DepartmentInfoApi;
import com.sz.qzxkj.mapper.DepartmentInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Service
public class DepartmentInfoService implements DepartmentInfoApi {

    @Autowired
    private DepartmentInfoMapper mapper;

    @Override
    public DepartmentInfo findById(Integer id) {

        return mapper.findById(id);
    }
}
