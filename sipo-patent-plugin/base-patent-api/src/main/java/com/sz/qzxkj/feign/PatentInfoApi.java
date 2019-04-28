package com.sz.qzxkj.feign;

import com.sz.qzxkj.entity.PatentInfo;
import com.sz.qzxkj.hystrix.PatentInfoApiHystrix;
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
import java.util.Optional;

/**
 * 创 建 时 间: 2019/3/21
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
@RestController
@Api(value = "专利组件")
@Resource(name = "对外接口")
@RequestMapping("/PatentInfoApi")
@FeignClient(name="sipo-patent-plugin",fallbackFactory=PatentInfoApiHystrix.class)
public interface PatentInfoApi {


    @GetMapping("/findById/{id}")
    @ApiImplicitParam(name = "id",required = true)
    @ApiOperation(value = "根据ID获得对象", notes = "对象查询", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Optional<PatentInfo> findById(@PathVariable("id")Integer id);

    @GetMapping("/findByPatentno/{patentno}")
    @ApiImplicitParam(name = "patentno",dataType = "String",required = true)
    @ApiOperation(value = "根据patentno获得对象", notes = "对象查询", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    PatentInfo findByPatentno(@PathVariable("patentno")String patentno);


}
