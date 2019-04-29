package com.sz.qzxkj.service;

import com.sz.qzxkj.entity.UserInfo;
import com.sz.qzxkj.feign.UserInfoApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 创 建 时 间: 2019/4/28
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Service
public class TestService {

    @Autowired
    private UserInfoApi userInfoApi;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Transactional
    public int saveUser(){
        log.info("调用开始:");
        UserInfo bean = new UserInfo();
        bean.setUsername("路人甲");
        bean.setBirthday(new Date());
        int aa = userInfoApi.save(bean);
        int ab = 1/0;
        return aa;
    }
}
