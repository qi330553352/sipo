package com.sz.qzxkj.hystrix;

import com.sz.qzxkj.feign.PermissionInfoApi;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 创 建 时 间: 2019/3/27
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class PermissionInfoApiHystrix implements FallbackFactory<PermissionInfoApi> {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public PermissionInfoApi create(Throwable e) {
        log.info(""+e);
        return new PermissionInfoApi() {


        };
    }
}
