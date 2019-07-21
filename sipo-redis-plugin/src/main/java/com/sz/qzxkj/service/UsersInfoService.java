package com.sz.qzxkj.service;

import com.sz.qzxkj.entity.UsersInfo;
import com.sz.qzxkj.repository.UsersInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * 创 建 时 间: 2019/7/21
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Service
@CacheConfig(cacheNames = "usersInfo")
public class UsersInfoService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UsersInfoRepository repository;


    @Cacheable(value="findById")
    public Optional<UsersInfo> findById(Integer id) {
        Optional<UsersInfo> user = repository.findById(id);
        //redisTemplate.opsForValue().set(String.valueOf(id),user);
        //redisTemplate.expire(String.valueOf(id),1, TimeUnit.DAYS);
        return user;
    }
}
