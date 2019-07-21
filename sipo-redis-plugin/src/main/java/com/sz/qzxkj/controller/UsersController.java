package com.sz.qzxkj.controller;

import com.sz.qzxkj.entity.UsersInfo;
import com.sz.qzxkj.service.UsersInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 创 建 时 间: 2019/7/21
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@RestController
@Api(value = "用户信息控制器")
@Resource(name = "用户控制器")
@RequestMapping("/users")
public class UsersController {

    @Autowired
    public UsersInfoService service;
    private Logger log = LoggerFactory.getLogger(UsersController.class);

    @GetMapping("/findById/{id}")
    @ApiImplicitParam(name = "id",required = true)
    @ApiOperation(value = "根据ID获得对象", notes = "对象查询", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Optional<UsersInfo> findById(@PathVariable("id")Integer id){
        log.info("参数 id:{}",id);
        return service.findById(id);
    }
}
