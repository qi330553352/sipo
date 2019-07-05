package com.sz.qzxkj.service;

import com.sz.qzxkj.entity.Solrj;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 创 建 时 间: 2019/7/5
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class SolrjServer {

    private static HttpSolrClient server = null;
    private static String url ="http://localhost:8081/solr/test2";

    public static HttpSolrClient getServer(){
        return new HttpSolrClient.Builder(url)
                .withConnectionTimeout(10000)
                .withSocketTimeout(60000)
                .build();

    }


    /**
     * add index
     */
    public static void addIndex()
    {
        HttpSolrClient server = SolrjServer.getServer();
        List<Solrj> c = new ArrayList<>();
        try {
            Solrj bo = new Solrj();
            bo.setId("2001");
            bo.setName("mary");
            bo.setScore(89);
            c.add(bo);
            Solrj bo2 = new Solrj();
            bo2.setId("2002");
            bo2.setName("honghong");
            bo2.setScore(100);
            c.add(bo2);

            server.addBeans(c);
            server.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * delete by condition
     */
    public static void delete(String condition){
        HttpSolrClient server = SolrjServer.getServer();
        try {
            server.deleteByQuery(condition);
            server.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * search index
     */
    public static void search()
    {
        HttpSolrClient server = SolrjServer.getServer();
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        query.setStart(0);
        query.setRows(5);
        QueryResponse queryResponse;
        try {
            queryResponse = server.query(query);
            List<Solrj>  list = queryResponse.getBeans(Solrj.class);
            for (Solrj bo : list) {
                System.out.println(bo.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        search();
    }


}
