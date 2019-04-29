package com.sz.qzxkj.service;

import com.sz.qzxkj.entity.UserInfo;
import com.sz.qzxkj.feign.UserInfoApi;
import com.sz.qzxkj.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Service
public class UserInfoService implements UserInfoApi {

    @Autowired
    private UserInfoMapper mapper;

    @Override
    public UserInfo findByPhoneno(String phoneno) {

        return mapper.findByPhoneno(phoneno);
    }

    @Override
    public int save(UserInfo bean) {

        return mapper.save(bean);
    }
}
