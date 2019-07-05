package com.sz.qzxkj;

import com.sz.qzxkj.service.SolrjServer;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 创 建 时 间: 2019/7/5
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class SolrjBasicTests {

    @Test
    public static void insert() {
        HttpSolrClient server = SolrjServer.getServer();
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id", "1003");
        doc.addField("title_s", "hello bobo!");
        doc.addField("des_s", "波波，你好！");
        try {
            server.add(doc);
            server.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void DeleteByQueryJobsId() {
        HttpSolrClient server = SolrjServer.getServer();
        try {
            server.deleteById("123456");
            server.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delDocs() {
        long start = System.currentTimeMillis();
        try {
            HttpSolrClient server = SolrjServer.getServer();
            List<String> ids = new ArrayList<>();
            ids.add("123456");
            server.deleteById(ids);
            server.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("time elapsed(ms):" + (System.currentTimeMillis() - start));
    }

    /**
     * ��ѯ�ĵ���
     */
    public static void search(String str) {
        HttpSolrClient server = SolrjServer.getServer();
        SolrQuery sQuery = new SolrQuery();
//		if(StringUtils.isBlank(str))
//			str = "*:*";
//		sQuery.setQuery(str);
//		sQuery.set("q", "des_s:test*");
        sQuery.setQuery("des_s:test*");
        sQuery.setStart(0);
        sQuery.setRows(5);

        QueryResponse queryResponse;
        try {
            queryResponse = server.query(sQuery);
            SolrDocumentList list = queryResponse.getResults();
            System.out.println("query result nums: " + list.getNumFound());
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getFieldValue("des_s"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
