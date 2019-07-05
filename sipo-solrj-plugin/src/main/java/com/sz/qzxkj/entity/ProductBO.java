package com.sz.qzxkj.entity;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

/**
 * 创 建 时 间: 2019/7/5
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Data
public class ProductBO implements Serializable {

    @Field
    private String id;
    @Field
    private String major_s;
    @Field
    private String subMajor_s;
    @Field
    private String brand_s;
    @Field
    private String model_s;
    @Field
    private int price_i;
    @Field
    private String title;
}
