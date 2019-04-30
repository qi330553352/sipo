package com.sz.qzxkj.service;

import com.sz.qzxkj.entity.PatentInfo;
import com.sz.qzxkj.feign.PatentInfoApi;
import com.sz.qzxkj.mapper.PatentInfoMapper;
import com.sz.qzxkj.repository.PatentInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    @Autowired
    private PatentInfoRepository repository;
    private Logger log = LoggerFactory.getLogger(PatentInfoService.class);

    @Override
    @Cacheable(value = "findById")
    public Optional<PatentInfo> findById(Integer id) {
        log.info("参数 id:{}",id);
        return repository.findById(id);
    }

    @Override
    public PatentInfo findByPatentno(String patentno) {
        log.info("参数 patentno:{}",patentno);
        return mapper.findByPatentno(patentno);
    }

    @Override
    public Page<PatentInfo> findInfo(Integer page,Integer pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC,"applyTime");
        PageRequest pageable = PageRequest.of(page,pageSize,sort);
        return repository.findAll(pageable);
    }
}
