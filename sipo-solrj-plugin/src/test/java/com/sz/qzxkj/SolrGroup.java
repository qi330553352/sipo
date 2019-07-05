package com.sz.qzxkj;

import com.sz.qzxkj.service.SolrjServer;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.Group;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.GroupParams;
import org.junit.Test;

import java.util.List;

/**
 * 创 建 时 间: 2019/7/5
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
public class SolrGroup {

    @Test
    public static void searchByGroup() {
        try {
            HttpSolrClient solrServer = SolrjServer.getServer();
            SolrQuery query = new SolrQuery("brand_s:海尔");
            // 设置通过Group查询为true，表示查询时使用Group机制
            query.setParam(GroupParams.GROUP, true);
            // 设置Group查询针对的域
            query.setParam(GroupParams.GROUP_FIELD, "brand_s");
            // 设置每个组最多返回的记录数，可用于数据采集;若只需要数量，可以设置为0
            query.setParam(GroupParams.GROUP_LIMIT, "1");
            // 设置返回的行数
            query.setRows(10);
            // 获取查询响应
            QueryResponse response = solrServer.query(query);
            if (response != null) {// 获取group查询响应
                GroupResponse groupResponse = response.getGroupResponse();
                if (groupResponse != null) {
                    List<GroupCommand> groupList = groupResponse.getValues();
                    for (GroupCommand groupCommand : groupList) {
                        List<Group> groups = groupCommand.getValues();
                        for (Group group : groups) {
//							System.out.println(group.getResult().get(0).getFirstValue("subMajor_s") + "  "
//									+ group.getResult().get(1).getFirstValue("subMajor_s"));
//							System.out.println(
//									"group查询..." + group.getGroupValue() + " 数量为：" + group.getResult().getNumFound()
//											+ "    " + group.getResult().get(0).getFieldValue("model_s"));
                            for(int i=0;i<group.getResult().size();i++){
                                System.out.println(group.getResult().get(i).getFieldValue("major_s")
                                        + "  " + group.getResult().get(i).getFieldValue("subMajor_s")
                                        + "  " + group.getResult().get(i).getFieldValue("brand_s")
                                        + "  " + group.getResult().get(i).getFieldValue("model_s")
                                        + "  " + group.getResult().get(i).getFieldValue("price_i"));
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
