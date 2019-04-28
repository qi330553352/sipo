package com.sz.qzxkj.config;

import com.sz.qzxkj.intercept.GunsUserFilter;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 创 建 时 间: 2019/3/25
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
@Configuration
public class ShiroConfig {

    @Bean("sessionManager")
    public SessionManager sessionManager(RedisShiroSessionDAO redisShiroSessionDAO,
                                         @Value("${beam.admin.redis-open}") boolean redisOpen,
                                         @Value("${beam.admin.shiro-redis}") boolean shiroRedis){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        //设置session过期时间为1小时(单位：毫秒)，默认为30分钟
        sessionManager.setGlobalSessionTimeout(60 * 60 * 1000);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdUrlRewritingEnabled(false);

        //如果开启redis缓存且beam.admin.shiro-redis=true，则shiro session存到redis里
        if(redisOpen && shiroRedis){
            sessionManager.setSessionDAO(redisShiroSessionDAO);
        }
        return sessionManager;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(UserRealm userRealm, SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        securityManager.setSessionManager(sessionManager);

        return securityManager;
    }

    @Bean //@Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        shiroFilter.setLoginUrl("/login/signin");
        shiroFilter.setUnauthorizedUrl("/");

        //session过期拦截
//        Map<String, Filter> myFilters = new HashMap<>();
//        myFilters.put("user", new GunsUserFilter());
//        shiroFilter.setFilters(myFilters);

        Map<String, String> filterMap = new LinkedHashMap<>();
        /*swagger 资源过滤*/
        filterMap.put("/swagger/**", "anon");
        filterMap.put("/v2/api-docs", "anon");
        filterMap.put("/swagger-ui.html", "anon");
        filterMap.put("/webjars/**", "anon");
        filterMap.put("/swagger-resources/**", "anon");
        filterMap.put("/css/**", "anon");
        filterMap.put("/fonts/**", "anon");
        filterMap.put("/images/**", "anon");
        filterMap.put("/js/**", "anon");

        filterMap.put("/login/**", "anon"); //登陆控制器
        filterMap.put("/kaptcha", "anon");  //验证码
        filterMap.put("/global/*", "anon");  //全局路径（错误或者超时）

        filterMap.put("/favicon.ico", "anon");
        filterMap.put("/**", "user");
        shiroFilter.setFilterChainDefinitionMap(filterMap);

        return shiroFilter;
    }


    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

}
