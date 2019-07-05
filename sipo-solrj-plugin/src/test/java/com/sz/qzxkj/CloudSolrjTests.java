package com.sz.qzxkj;

import com.sz.qzxkj.service.CloudSolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 创 建 时 间: 2019/7/5
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class CloudSolrjTests {

    @Test
    public static void addIndex() {
        CloudSolrClient server = CloudSolrServer.getServer();
        SolrInputDocument doc1 = new SolrInputDocument();
        doc1.addField("id", "1001");
        doc1.addField("name_s", "王海");

        SolrInputDocument doc2 = new SolrInputDocument();
        doc2.addField("id", "1002");
        doc2.addField("name_s", "张芳");

        SolrInputDocument doc3 = new SolrInputDocument();
        doc3.addField("id", "1003");
        doc3.addField("name_s", "刘军");

        Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
        docs.add(doc1);
        docs.add(doc2);
        docs.add(doc3);

        try {
            server.add(docs);
            server.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
