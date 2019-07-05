package com.sz.qzxkj;

import com.sz.qzxkj.entity.ProductBO;
import com.sz.qzxkj.service.SolrjServer;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * 创 建 时 间: 2019/7/5
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class SolrFacet {

    /**
     * 添加索引,准备测试数据
     */
    public static void addIndex() {
        HttpSolrClient server = SolrjServer.getServer();
        List<ProductBO> beans = new ArrayList<ProductBO>();
        //家电类
        ProductBO dianshiBO1 = new ProductBO();
        dianshiBO1.setId("1001");
        dianshiBO1.setTitle("海尔模卡（MOOKA） 65K5 65英寸安卓智能网络窄边框全高清LED液晶电视");
        dianshiBO1.setMajor_s("家用电器");
        dianshiBO1.setSubMajor_s("电视");
        dianshiBO1.setBrand_s("海尔");
        dianshiBO1.setModel_s("65K5");
        dianshiBO1.setPrice_i(5400);
        beans.add(dianshiBO1);
        ProductBO dianshiBO2 = new ProductBO();
        dianshiBO2.setId("1002");
        dianshiBO2.setTitle("三星（SAMSUNG）UA55JU5900JXXZ 55英寸 4K超高清智能 LED液晶电视 黑色");
        dianshiBO2.setMajor_s("家用电器");
        dianshiBO2.setSubMajor_s("电视");
        dianshiBO2.setBrand_s("三星");
        dianshiBO2.setModel_s("UA55JU5900");
        dianshiBO2.setPrice_i(6400);
        beans.add(dianshiBO2);

        ProductBO kongtiaoBO1 = new ProductBO();
        kongtiaoBO1.setId("2001");
        kongtiaoBO1.setTitle("格力(GREE) 大1匹 变频 Q铂 壁挂式冷暖空调 KFR-26GW/(26596)FNAa-A3");
        kongtiaoBO1.setMajor_s("家用电器");
        kongtiaoBO1.setSubMajor_s("空调");
        kongtiaoBO1.setBrand_s("格力");
        kongtiaoBO1.setModel_s("KFR-26GW/(26596)FNAa-A3");
        kongtiaoBO1.setPrice_i(7700);
        beans.add(kongtiaoBO1);
        ProductBO kongtiaoBO2 = new ProductBO();
        kongtiaoBO2.setId("2002");
        kongtiaoBO2.setTitle("奥克斯（AUX）正1.5匹 冷暖 定速 隐藏式显示屏 壁挂式 空调 KFR-35GW/HFJ+3");
        kongtiaoBO2.setMajor_s("家用电器");
        kongtiaoBO2.setSubMajor_s("空调");
        kongtiaoBO2.setBrand_s("奥克斯");
        kongtiaoBO2.setModel_s("KFR-35GW/HFJ+3");
        kongtiaoBO2.setPrice_i(6600);
        beans.add(kongtiaoBO2);
        ProductBO kongtiaoBO3 = new ProductBO();
        kongtiaoBO3.setId("2003");
        kongtiaoBO3.setTitle("海尔（Haier）1.5匹 变频 静音空调 冷暖 壁挂式空调 KFR-35GW/01JDA23A");
        kongtiaoBO3.setMajor_s("家用电器");
        kongtiaoBO3.setSubMajor_s("空调");
        kongtiaoBO3.setBrand_s("海尔");
        kongtiaoBO3.setModel_s("KFR-35GW/01JDA23A");
        kongtiaoBO3.setPrice_i(9600);
        beans.add(kongtiaoBO3);

        try {
            server.addBeans(beans);
            server.commit();
            System.out.println("提交完毕！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void facetQuery(){
        HttpSolrClient server = SolrjServer.getServer();
        SolrQuery sQuery = new SolrQuery();
        try{
            String para = "*:*";
            sQuery.setFacet(true);
            sQuery.addFacetField(new String[]{"subMajor_s","brand_s"});
            sQuery.setFacetLimit(100);//限制facet返回数量
            sQuery.setFacetMissing(false);//不统计null的值
            sQuery.setFacetMinCount(1);//分组的数据最小为1
            sQuery.addFacetQuery("price_i:[1000 TO 10000]");
            sQuery.setQuery(para);
            QueryResponse queryResponse;
            queryResponse = server.query(sQuery);
            List<FacetField> facets = queryResponse.getFacetFields();// 返回的facet列表
            for (FacetField facet:facets){
                System.out.println(facet.getName());
                System.out.println("---------------");
                List<FacetField.Count> counts = facet.getValues();
                for(FacetField.Count count:counts){
                    System.out.println(count.getName()+":"+count.getCount());
                }
                System.out.println();
            }

        }catch(Exception e){e.printStackTrace();}
    }
    public static void main(String[] args) {
        facetQuery();
    }

}
