package com.sz.qzxkj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 创 建 时 间: 2019/3/23
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EnableTransactionManagement
public class AggregationManagement {

    public static void main(String[] args) {
        SpringApplication.run(AggregationManagement.class, args);
    }
}
