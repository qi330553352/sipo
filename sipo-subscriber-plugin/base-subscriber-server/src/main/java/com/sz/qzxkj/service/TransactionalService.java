package com.sz.qzxkj.service;

import com.sz.qzxkj.entity.RoleInfo;
import com.sz.qzxkj.mapper.RoleInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * 创 建 时 间: 2019/4/29
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Service
public class TransactionalService {

    @Autowired
    private RoleInfoMapper mapper;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    //---------获得代理对象-----------------
    @Autowired
    private ApplicationContext ac;
    private TransactionalService serviceProxy;

    @PostConstruct
    public void init(){
        serviceProxy = ac.getBean(TransactionalService.class);
    }

    /** 业务场景
     1、在调用parent()之前要调用child()
     2、child不重要，child成功与否不能影响parent()
     执行结果：
     parent()与child()都成功！！！

     */
    @Transactional
    public void parent(){
        log.info("======parent()方法被调用========");

        try{
            this.child();
//            获得代理对象的4中方式：
//            TransactionalService serviceProxy = (TransactionalService)AopContext.currentProxy();  方式一
//            serviceProxy = serviceProxy;  方式二
        }catch (Exception e){
            log.error("parent catched child exception:"+e);
        }

        RoleInfo role = new RoleInfo();
        role.setRoleName("职员1");
        role.setRemark("很可爱1");
        mapper.save(role);
    }

    /** 原因
     1、从日志中后，child事务注解没起作用
     2、事务失效的根本原因：Spring的动态代理（AOP）
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void child(){
        log.info("======child()方法被调用========");
        RoleInfo role = new RoleInfo();
        role.setRoleName("职员2");
        role.setRemark("很可爱2");
        mapper.save(role);
        int a = 1/0;
    }
}
