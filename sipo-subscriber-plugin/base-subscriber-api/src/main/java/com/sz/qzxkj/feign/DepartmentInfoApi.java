package com.sz.qzxkj.feign;

import com.sz.qzxkj.entity.DepartmentInfo;
import com.sz.qzxkj.hystrix.RoleInfoApiHystrix;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@RestController
@Api(value = "专利名称组件")
@Resource(name = "对外接口")
@RequestMapping("/DepartmentInfoApi")
@FeignClient(name="sipo-subscriber-plugin",fallbackFactory=RoleInfoApiHystrix.class)
public interface DepartmentInfoApi {

    @GetMapping("/findById/{id}")
    @ApiImplicitParam(name = "id", value = "用户文件对象ID", required = true, dataType = "Integer")
    @ApiOperation(value="获得用户文件对象", notes="根据id获得用户文件对象",httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    DepartmentInfo findById(@PathVariable("id")Integer id);
}
