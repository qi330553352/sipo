package com.sz.qzxkj.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
@Component
public class LocaleMessage {

    @Autowired
    private MessageSource messageSource;

    /**
     * @param code：对应文本配置的key.
     * @return 对应地区的语言消息字符串
     */
    public String getMessage(String code){
        return this.getMessage(code,new Object[]{});
    }

    public String getMessage(String code,String defaultMessage){
        return this.getMessage(code,null,defaultMessage);
    }

    public String getMessage(String code,String defaultMessage,Locale locale){
        return this.getMessage(code,null,defaultMessage,locale);
    }

    public String getMessage(String code,Locale locale){
        return this.getMessage(code,null,"",locale);
    }

    public String getMessage(String code,Object[] args){
        return this.getMessage(code,args,"");
    }

    public String getMessage(String code,Object[] args,Locale locale){
        return this.getMessage(code,args,"",locale);
    }

    public String getMessage(String code,Object[] args,String defaultMessage){
        Locale locale = LocaleContextHolder.getLocale();
        return this.getMessage(code,args, defaultMessage,locale);
    }

    public String getMessage(String code,Object[]args,String defaultMessage,Locale locale){
        return messageSource.getMessage(code,args, defaultMessage,locale);
    }

}
