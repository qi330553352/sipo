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
public class Solrj implements Serializable {

    @Field
    public String id;
    @Field
    public String name;
    @Field
    public int score;
    @Field
    public String title;
    @Field
    public String des;

}
