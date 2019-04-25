package com.sz.qzxkj.feign;

import com.sz.qzxkj.hystrix.ApplicantInfoApiHystrix;
import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 创 建 时 间: 2019/3/21
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
@RestController
@Api(value = "专利名称组件")
@Resource(name = "对外接口")
@RequestMapping("/ApplicantInfoApi")
@FeignClient(name="sipo-patent-plugin",fallbackFactory=ApplicantInfoApiHystrix.class)
public interface ApplicantInfoApi {


}
