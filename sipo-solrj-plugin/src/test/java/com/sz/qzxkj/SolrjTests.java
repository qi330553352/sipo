package com.sz.qzxkj;

import com.sz.qzxkj.service.SolrjServer;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 创 建 时 间: 2019/7/5
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class SolrjTests {

    public static void addIndex() {
        HttpSolrClient server = SolrjServer.getServer();
        Collection<SolrInputDocument> c = new ArrayList<SolrInputDocument>();
        try {
            SolrInputDocument doc = new SolrInputDocument();
            doc.addField("id", "1001");
            doc.addField("name_s", "liming");
            doc.addField("score_i", "88");
            c.add(doc);
            SolrInputDocument doc1 = new SolrInputDocument();
            doc1.addField("id", "1002");
            doc1.addField("name_s", "wangpeng");
            doc1.addField("score_i", "34");
            c.add(doc1);
            SolrInputDocument doc3 = new SolrInputDocument();
            doc3.addField("id", "1003");
            doc3.addField("name_s", "dongdong");
            doc3.addField("score_i", "67");
            c.add(doc3);
            server.add(c);
            server.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * delete by id
     */
    public static void delete() {
        HttpSolrClient server = SolrjServer.getServer();
        try {
            server.deleteById("333333");
            server.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * delete by ids
     */
    public static void deleteList() {
        HttpSolrClient server = SolrjServer.getServer();
        try {
            List<String> ids = new ArrayList<String>();
            ids.add("1001");
            ids.add("1002");
            server.deleteById(ids);
            server.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public static void search() {
        HttpSolrClient server = SolrjServer.getServer();
        SolrQuery query = new SolrQuery();
//		query.setQuery("*:*");
        query.set("q", "*:*");
        query.setStart(0);
        query.setRows(5);
        QueryResponse queryResponse;
        try {
            queryResponse = server.query(query);
            SolrDocumentList list = queryResponse.getResults();
            System.out.println("query result nums: " + list.getNumFound());
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getFieldValue("name_s"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
