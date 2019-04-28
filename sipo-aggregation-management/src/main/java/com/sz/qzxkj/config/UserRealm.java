package com.sz.qzxkj.config;

import com.sz.qzxkj.entity.RoleInfo;
import com.sz.qzxkj.entity.UserInfo;
import com.sz.qzxkj.feign.UserInfoApi;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 创 建 时 间: 2019/3/26
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoApi userInfoApi;

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String phoneno = (String) principals.getPrimaryPrincipal();
//        UserInfo userInfo = userInfoApi.findByPhoneno(phoneno);
        List<String> roleNameList = Collections.emptyList();
        Set<String> permsSet = new HashSet<>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        info.addRoles(roleNameList);
        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
        UserInfo userInfo = userInfoApi.findByPhoneno(token.getUsername());
        String credentials = userInfo.getPassword();
        ByteSource credentialsSalt = ByteSource.Util.bytes(userInfo.getSalt());
        String realmName = userInfo.getPhoneno();
        return new SimpleAuthenticationInfo(realmName,credentials,userInfo.getSalt());
    }
}
