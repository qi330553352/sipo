package com.sz.qzxkj.example.chapter1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 创 建 时 间: 2019/5/23
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SenderTests {

    @Autowired
    private Sender sender;
    @Test
    public void contextLoads() {
        sender.send();
    }
}
