package com.sz.qzxkj;

import com.sz.qzxkj.entity.Solrj;
import com.sz.qzxkj.service.SolrjServer;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.util.List;

/**
 * 创 建 时 间: 2019/7/5
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class SolrMultiTests {

    public static void search(String str)
    {
        HttpSolrClient server = SolrjServer.getServer();
        SolrQuery sQuery = new SolrQuery();
        sQuery.setQuery(str);
        sQuery.setStart(0);
        sQuery.setRows(5);
        sQuery.set("shards", "localhost:8081/solr/test,localhost:8081/solr/core1,localhost:8081/solr/core2");
        QueryResponse queryResponse;
        try {
            queryResponse = server.query(sQuery);
            List<Solrj> indexBOLists = queryResponse.getBeans(Solrj.class);
            for (Solrj bo : indexBOLists) {
                System.out.println(bo.getDes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        search("*:*");
    }
}
