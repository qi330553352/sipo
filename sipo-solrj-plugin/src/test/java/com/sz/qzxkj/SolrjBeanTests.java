package com.sz.qzxkj;

import com.sz.qzxkj.entity.Solrj;
import com.sz.qzxkj.service.SolrjServer;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 创 建 时 间: 2019/7/5
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class SolrjBeanTests {

    @Test
    public static void addBeanIndex() {
        HttpSolrClient server = SolrjServer.getServer();
        List<Solrj> beans = new ArrayList<>();
        Solrj bo = new Solrj();
        bo.setId("333333");
        bo.setTitle("helo world, test2.");
        bo.setDes("test2 bean.");
        beans.add(bo);
        try {
            server.addBeans(beans);
            server.commit();
            System.out.println("----�����������!!!----");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void search(String str) {
        HttpSolrClient server = SolrjServer.getServer();
        SolrQuery sQuery = new SolrQuery();
        if(StringUtils.isBlank(str))
            str = "*:*";
        sQuery.setQuery(str);
        sQuery.setStart(0);
        sQuery.setRows(5);

        QueryResponse queryResponse;
        try {
            queryResponse = server.query(sQuery);
            List<Solrj> indexBOLists = queryResponse.getBeans(Solrj.class);
            System.out.println("----------------------------" + indexBOLists.size());
            for (Solrj bo : indexBOLists) {
                System.out.println(bo.getDes());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delteIndex(String condition){
        try {
            HttpSolrClient server = SolrjServer.getServer();
            server.deleteByQuery(condition);
            //server.deleteById(id);
            server.commit();
            System.out.println("������ϣ�");
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
