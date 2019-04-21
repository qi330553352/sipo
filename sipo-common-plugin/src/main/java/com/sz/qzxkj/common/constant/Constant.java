package com.sz.qzxkj.common.constant;

import lombok.Getter;

/**
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
public class Constant {

    /** 超级管理员ID */
    public static final int SUPER_ADMIN = 1;

    public static final String APPNAME = "appname";

    /**
     * 菜单类型
     */
    public enum MenuType {

        CATALOG(0), //目录
        MENU(1),    //菜单
        BUTTON(2);  //按钮

        @Getter
        private int value;

        MenuType(int value) {
            this.value = value;
        }
    }

    /**
     * 定时任务状态
     */
    public enum ScheduleStatus {

        NORMAL(0),  //正常
        PAUSE(1);   //暂停

        @Getter
        private int value;

        ScheduleStatus(int value) {
            this.value = value;
        }
    }

    /**
     * 云服务商
     */
    public enum CloudService {
        QINIU(1),   //七牛云
        ALIYUN(2),  //阿里云
        QCLOUD(3);  //腾讯云

        @Getter
        private int value;

        CloudService(int value) {
            this.value = value;
        }
    }
}
