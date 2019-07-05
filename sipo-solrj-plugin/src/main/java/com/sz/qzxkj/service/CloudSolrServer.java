package com.sz.qzxkj.service;

import org.apache.solr.client.solrj.impl.CloudSolrClient;

/**
 * 创 建 时 间: 2019/7/5
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class CloudSolrServer {

    public static CloudSolrClient server = null;

    public static CloudSolrClient getServer() {
        final String zkHost = "localhost:2181,localhost:2182,localhost:2183";
        final String defaultCollection = "core1";
        final int zkClientTimeout = 20000;
        final int zkConnectTimeout = 1000;
        server = new CloudSolrClient.Builder().withZkHost(zkHost).build();
        server.setDefaultCollection(defaultCollection);
        server.setZkClientTimeout(zkClientTimeout);
        server.setZkConnectTimeout(zkConnectTimeout);

        server.connect();
        return server;
    }

    public static void main(String[] args) {
        System.out.println(getServer());
    }
}
