package com.sz.qzxkj.hystrix;

import com.sz.qzxkj.feign.ApplicantInfoApi;
import com.sz.qzxkj.feign.PatentInfoApi;
import feign.hystrix.FallbackFactory;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 创 建 时 间: 2019/3/21
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
public class ApplicantInfoApiHystrix  implements FallbackFactory<ApplicantInfoApi> {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public ApplicantInfoApi create(Throwable throwable) {

        return new ApplicantInfoApi(){

        };
    }
}
