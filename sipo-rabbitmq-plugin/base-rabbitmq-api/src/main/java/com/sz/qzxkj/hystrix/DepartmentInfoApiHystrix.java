package com.sz.qzxkj.hystrix;

import com.sz.qzxkj.entity.DepartmentInfo;
import com.sz.qzxkj.feign.DepartmentInfoApi;
import feign.hystrix.FallbackFactory;
import lombok.extern.log4j.Log4j2;

/**
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Log4j2
public class DepartmentInfoApiHystrix implements FallbackFactory<DepartmentInfoApi> {

    @Override
    public DepartmentInfoApi create(Throwable e) {
        log.info("使用组件时出错啦:"+e);
        return new DepartmentInfoApi() {
            @Override
            public DepartmentInfo findById(Integer id) {

                return new DepartmentInfo();
            }
        };
    }
}
