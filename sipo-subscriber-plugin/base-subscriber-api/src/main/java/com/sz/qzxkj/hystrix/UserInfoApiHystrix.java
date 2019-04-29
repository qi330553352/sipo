package com.sz.qzxkj.hystrix;

import com.sz.qzxkj.entity.UserInfo;
import com.sz.qzxkj.feign.UserInfoApi;
import feign.hystrix.FallbackFactory;
import lombok.extern.log4j.Log4j2;

/**
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Log4j2
public class UserInfoApiHystrix implements FallbackFactory<UserInfoApi> {
    @Override
    public UserInfoApi create(Throwable e) {

        return new UserInfoApi(){
            @Override
            public UserInfo findByPhoneno(String phoneno) {

                return new UserInfo();
            }

            @Override
            public int save(UserInfo bean) {

                return 0;
            }
        };
    }
}
