package com.sz.qzxkj.feign;

import com.sz.qzxkj.entity.UserInfo;
import com.sz.qzxkj.hystrix.UserInfoApiHystrix;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
@RestController
@Api(value = "专利名称组件")
@Resource(name = "对外接口")
@RequestMapping("/UserInfoApi")
@FeignClient(name="sipo-subscriber-plugin",fallbackFactory=UserInfoApiHystrix.class)
public interface UserInfoApi {

    @GetMapping("/findByPhoneno")
    @ApiImplicitParam(name = "phoneno", value = "用户账号", required = true, dataType = "String")
    @ApiOperation(value="获得用户对象", notes="根据Phoneno获得用户对象",httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    UserInfo findByPhoneno(@RequestParam(value = "phoneno") String phoneno);
}
