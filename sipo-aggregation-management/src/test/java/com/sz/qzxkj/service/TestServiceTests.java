package com.sz.qzxkj.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 创 建 时 间: 2019/4/28
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceTests {

    @Autowired
    private TestService service;

    @Test
    public void test(){
        service.saveUser();
    }
}
