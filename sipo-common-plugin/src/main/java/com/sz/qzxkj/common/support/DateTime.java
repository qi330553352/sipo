package com.sz.qzxkj.common.support;

import java.util.Date;

/**
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
public class DateTime extends Date {

    /**
     * 转换JDK date为 DateTime
     * @param date JDK Date
     * @return DateTime
     */
    public static DateTime parse(Date date) {
        return new DateTime(date);
    }

    /**
     * 当前时间
     */
    public DateTime() {
        super();
    }

    /**
     * 给定日期的构造
     * @param date 日期
     */
    public DateTime(Date date) {
        this(date.getTime());
    }

    /**
     * 给定日期毫秒数的构造
     * @param timeMillis 日期毫秒数
     */
    public DateTime(long timeMillis) {
        super(timeMillis);
    }

    @Override
    public String toString() {
        return DateTimeKit.formatDateTime(this);
    }

    public String toString(String format) {
        return DateTimeKit.format(this, format);
    }

    /**
     * @return 输出精确到毫秒的标准日期形式
     */
    public String toMsStr() {
        return DateTimeKit.format(this, DateTimeKit.NORM_DATETIME_MS_PATTERN);
    }

    /**
     * @return java.util.Date
     */
    public Date toDate() {
        return new Date(this.getTime());
    }

}
