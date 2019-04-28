package com.sz.qzxkj.utils;

import com.sz.qzxkj.config.properties.BeamAdminProperties;
import com.sz.qzxkj.holder.SpringContextHolder;

/** 验证码工具类
 * 创 建 时 间: 2019/3/27
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
public class KaptchaUtil {

    private boolean kaptchaOnOff = false;

    public boolean isKaptchaOnOff() {
        return kaptchaOnOff;
    }
    /**
     * 获取验证码开关
     */
    public void setKaptchaOnOff() {
        this.kaptchaOnOff = SpringContextHolder.getBean(BeamAdminProperties.class).getKaptchaOpen();
    }
}
