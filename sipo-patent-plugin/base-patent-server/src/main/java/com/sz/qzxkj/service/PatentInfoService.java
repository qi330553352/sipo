package com.sz.qzxkj.service;

import com.sz.qzxkj.feign.PatentInfoApi;
import com.sz.qzxkj.mapper.PatentInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创 建 时 间: 2019/3/21
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
@Service
public class PatentInfoService implements PatentInfoApi {

    @Autowired
    private PatentInfoMapper mapper;
}
