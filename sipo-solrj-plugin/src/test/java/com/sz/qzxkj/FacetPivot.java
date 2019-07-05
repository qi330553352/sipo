package com.sz.qzxkj;

import com.sz.qzxkj.service.SolrjServer;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.PivotField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.util.NamedList;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * 创 建 时 间: 2019/7/5
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class FacetPivot {

    @Test
    public static void facetPivotQuery() {
        HttpSolrClient server = SolrjServer.getServer();
        SolrQuery sQuery = new SolrQuery();
        String para = "*:*";
        sQuery.setFacet(true);
        sQuery.add("facet.pivot", "major_s,subMajor_s,brand_s");// 多维度分组查询
        sQuery.setFacetLimit(1000);
        sQuery.setQuery(para);
        try {
            QueryResponse response = server.query(sQuery, SolrRequest.METHOD.POST);
            NamedList<List<PivotField>> namedList = response.getFacetPivot();
            System.out.println(namedList);
            if (namedList != null) {
                List<PivotField> pivotList = null;
                for (int i = 0; i < namedList.size(); i++) { // 此处的多次循环可以用递归
                    pivotList = namedList.getVal(i);
                    if (pivotList != null) {
                        for (PivotField pivot : pivotList) {
                            System.out.println("一级 : " + pivot.getValue() + "   " + pivot.getCount());
                            List<PivotField> fieldList = pivot.getPivot();
                            if (fieldList != null) {
                                for (PivotField field : fieldList) {
                                    System.out.println("二级 : " + field.getValue() + "   " + field.getCount());
                                    List<PivotField> fieldList1 = field.getPivot();
                                    if (fieldList1 != null) {
                                        for (PivotField field1 : fieldList1) {
                                            System.out.println("三级 : " + field1.getValue() + "   " + field1.getCount());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
