package com.sz.qzxkj.common.shiro;

import com.sz.qzxkj.common.enumeration.RetEnum;
import com.sz.qzxkj.common.exception.BeamException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
public class ShiroUtils {

    private static final String NAMES_DELIMETER = ",";

    /**  加密算法 */
    public final static String hashAlgorithmName = "SHA-256";
    /**  循环次数 */
    public final static int hashIterations = 16;

    /**
     * 加密
     * @param password
     * @param salt
     * @return
     */
    public static String sha256(String password, String salt) {
        return new SimpleHash(hashAlgorithmName, password, salt, hashIterations).toString();
    }

    /**
     * 从shiro获取session
     *
     */
    public static Session getSession() {
        return getSubject().getSession();
    }

    /**
     * 获取当前 Subject
     *
     * @return Subject
     */
    public static Subject getSubject() {

        return SecurityUtils.getSubject();
    }

    /**
     * 获取封装的 ShiroUser
     *
     * @return ShiroUser
     */
    public static ShiroUser getUserEntity() {
        return (ShiroUser) SecurityUtils.getSubject().getPrincipal();
    }

    //获取userId
    public static Integer getUserId() {
        return getUserEntity().getId();
    }


    public static void setSessionAttribute(Object key, Object value) {

        getSession().setAttribute(key, value);
    }

    /**
     * 获取shiro指定的sessionKey
     *
     */
    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }

    /**
     * 移除shiro指定的sessionKey
     */
    public static void removeSessionAttr(String key) {
        Session session = getSession();
        if (session != null)
            session.removeAttribute(key);
    }

    public static boolean isLogin() {

        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    public static void logout() {

        SecurityUtils.getSubject().logout();
    }

    //获取验证码
    public static String getKaptcha(String key) {
        Object kaptcha = getSessionAttribute(key);
        if(kaptcha == null){
            throw new BeamException(RetEnum.CAPTCHA_LAPSED);
        }
        removeSessionAttr(key);
        return kaptcha.toString();
    }

    /**
     * 验证当前用户是否属于该角色？,使用时与lacksRole 搭配使用
     *
     * @param roleName
     *            角色名
     * @return 属于该角色：true，否则false
     */
    public static boolean hasRole(String roleName) {
        return getSubject() != null && roleName != null
                && roleName.length() > 0 && getSubject().hasRole(roleName);
    }

    /**
     * 与hasRole标签逻辑相反，当用户不属于该角色时验证通过。
     *
     * @param roleName
     *            角色名
     * @return 不属于该角色：true，否则false
     */
    public static boolean lacksRole(String roleName) {
        return !hasRole(roleName);
    }

    /**
     * 验证当前用户是否属于以下任意一个角色。
     *
     * @param roleNames
     *            角色列表
     * @return 属于:true,否则false
     */
    public static boolean hasAnyRoles(String roleNames) {
        boolean hasAnyRole = false;
        Subject subject = getSubject();
        if (subject != null && roleNames != null && roleNames.length() > 0) {
            for (String role : roleNames.split(NAMES_DELIMETER)) {
                if (subject.hasRole(role.trim())) {
                    hasAnyRole = true;
                    break;
                }
            }
        }
        return hasAnyRole;
    }

    /**
     * 验证当前用户是否属于以下所有角色。
     *
     * @param roleNames
     *            角色列表
     * @return 属于:true,否则false
     */
    public static boolean hasAllRoles(String roleNames) {
        boolean hasAllRole = true;
        Subject subject = getSubject();
        if (subject != null && roleNames != null && roleNames.length() > 0) {
            for (String role : roleNames.split(NAMES_DELIMETER)) {
                if (!subject.hasRole(role.trim())) {
                    hasAllRole = false;
                    break;
                }
            }
        }
        return hasAllRole;
    }

    /**
     * 验证当前用户是否拥有指定权限,使用时与lacksPermission 搭配使用
     *
     * @param permission
     *            权限名
     * @return 拥有权限：true，否则false
     */
    public static boolean hasPermission(String permission) {
        return getSubject() != null && permission != null
                && permission.length() > 0
                && getSubject().isPermitted(permission);
    }

    /**
     * 与hasPermission标签逻辑相反，当前用户没有制定权限时，验证通过。
     *
     * @param permission
     *            权限名
     * @return 拥有权限：true，否则false
     */
    public static boolean lacksPermission(String permission) {
        return !hasPermission(permission);
    }

    /**
     * 已认证通过的用户。不包含已记住的用户，这是与user标签的区别所在。与notAuthenticated搭配使用
     *
     * @return 通过身份验证：true，否则false
     */
    public static boolean isAuthenticated() {
        return getSubject() != null && getSubject().isAuthenticated();
    }

    /**
     * 未认证通过用户，与authenticated标签相对应。与guest标签的区别是，该标签包含已记住用户。。
     *
     * @return 没有通过身份验证：true，否则false
     */
    public static boolean notAuthenticated() {
        return !isAuthenticated();
    }

    /**
     * 认证通过或已记住的用户。与guset搭配使用。
     * @return 用户：true，否则 false
     */
    public static boolean isUser() {
        return getSubject() != null && getSubject().getPrincipal() != null;
    }

    /**
     * 验证当前用户是否为“访客”，即未认证（包含未记住）的用户。用user搭配使用
     * @return 访客：true，否则false
     */
    public static boolean isGuest() {
        return !isUser();
    }

    /**
     * 输出当前用户信息，通常为登录帐号信息。
     * @return 当前用户信息
     */
    public static String principal() {
        if (getSubject() != null) {
            Object principal = getSubject().getPrincipal();
            return principal.toString();
        }
        return "";
    }

}
