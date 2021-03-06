package com.sz.qzxkj.feign;

import com.sz.qzxkj.hystrix.PermissionInfoApiHystrix;
import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 创 建 时 间: 2019/3/27
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@RestController
@Api(value = "专利名称组件")
@Resource(name = "对外接口")
@RequestMapping("/PermissionInfoApi")
@FeignClient(name="sipo-subscriber-plugin",fallbackFactory=PermissionInfoApiHystrix.class)
public interface PermissionInfoApi {

}
