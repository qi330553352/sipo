package com.sz.qzxkj;

import com.sz.qzxkj.entity.ProductBO;
import com.sz.qzxkj.service.SolrjServer;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.StringUtils;
import org.apache.solr.common.util.SimpleOrderedMap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 创 建 时 间: 2019/7/5
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class SolrMlt {

    @Test
    public static void Mlt(){
        HttpSolrClient solrServer = SolrjServer.getServer();
        SolrQuery query = new SolrQuery();
        List<ProductBO> articles = new ArrayList<ProductBO>();
        try {
            query.setQuery("id:" + 2002)
                    .setParam("fl", "id,title,brand_s") //返回的字段
                    .setParam("mlt", "true")            //打开组件
                    .setParam("mlt.fl", "title")        //用于判断相似的字段
                    .setParam("mlt.mindf", "1")         //过滤文档数小于1的文档集合
                    .setParam("mlt.mintf", "1")			//过滤关键词小于1的文档
                    .setParam("mlt.count", String.valueOf(10));

            QueryResponse response =  solrServer.query(query);
            SimpleOrderedMap<SolrDocumentList> mltResults = (SimpleOrderedMap<SolrDocumentList>) response.getResponse().get("moreLikeThis");
            for (int i = 0; i < mltResults.size(); i++) {
                SolrDocumentList items = mltResults.getVal(i);
                for (SolrDocument doc : items) {
                    String idStr = doc.getFieldValue("id").toString();
                    if (StringUtils.equals(idStr, "2002")) continue;// 排除本身
                    ProductBO article = new ProductBO();
                    article.setId(idStr);
                    article.setTitle(doc.getFieldValue("title").toString());
                    article.setBrand_s(doc.getFieldValue("brand_s").toString());
                    articles.add(article);
                    System.out.println(article.getTitle());
                }
            }
        }catch(Exception e){e.printStackTrace();}


    }
}
