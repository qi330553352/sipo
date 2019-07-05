package com.sz.qzxkj;

import com.sz.qzxkj.entity.ProductBO;
import com.sz.qzxkj.service.SolrjServer;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * 创 建 时 间: 2019/7/5
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class SolrHighlight {

    @Test
    public static void highLight() {
        HttpSolrClient server = SolrjServer.getServer();
        SolrQuery query = new SolrQuery();
        query.setQuery("title:变频");
        query.setHighlight(true);// 开启高亮功能
        query.addHighlightField("title");// 高亮字段
        query.setHighlightSimplePre("<font color='red'>");// 渲染标签
        query.setHighlightSimplePost("</font>");// 渲染标签
        QueryResponse response = null;
        try {
            response = server.query(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        SolrDocumentList lists = response.getResults();//查询结果集
        String tmpId = "";
        Map<String,Map<String,List<String>>>highlightMap=response.getHighlighting();
        for (SolrDocument solrDocument : lists) {
            ProductBO at = new ProductBO();
            tmpId = solrDocument.getFieldValue("id").toString();
            at.setId(tmpId);
            at.setSubMajor_s(solrDocument.getFieldValue("subMajor_s").toString());
            at.setTitle(solrDocument.getFieldValue("title").toString());
            List<String> titleList = highlightMap.get(tmpId).get("title");
            if(titleList != null && titleList.size() > 0){
                at.setTitle(titleList.get(0));//获取并设置高亮的字段title
            }else{
                at.setTitle(solrDocument.getFieldValue("title").toString());
            }
            System.out.println(at.getSubMajor_s() + " | " + at.getTitle());
        }

    }

}
