package com.sz.qzxkj;

import com.sz.qzxkj.entity.*;
import com.sz.qzxkj.mapper.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 创 建 时 间: 2019/4/4
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ExampleTests {

    @Autowired
    private WgsjzlqsyMapper wgsjzlqsyMapper;
    @Autowired
    private ApplicantInfoMapper applicantInfoMapper;
    @Autowired
    private PatentInfoMapper patentInfoMapper;
    @Autowired
    private AddressInfoMapper addressInfoMapper;
    @Autowired
    private PatentNoticeInfoMapper patentNoticeInfoMapper;
    @Autowired
    private RelationPatentApplicationMapper relationPatentApplicationMapper;


    @Test
    public void update() throws Exception{
        List<Wgsjzlqsy> list = wgsjzlqsyMapper.findAll();
        for(Wgsjzlqsy bean : list){
            String address = bean.getDz();
            if(address.startsWith("地址")) address = address.replace("地址","");
            address = address.trim();
            AddressInfo addressInfo = new AddressInfo();
            addressInfo.setAddress(address);
            addressInfoMapper.save(addressInfo);
        }
    }



    @Test
    public void txt() throws Exception{
        String path = "D:\\我的文件\\专利数据\\WGSQGB2701.txt";
        InputStreamReader bis = new InputStreamReader(new FileInputStream(new File(path)),"gbk");
        BufferedReader br = new BufferedReader(bis);
        String line = "";
        int i = 0;
        int idx = 1;
        String previous = "";
        StringBuffer sb = new StringBuffer();
        Wgsjzlqsy bean = new Wgsjzlqsy();
        while (line != null) {++idx;
            line = br.readLine();
            if(StringUtils.isEmpty(line)) continue;
            ++i;
            //if(i==20000) break;
            if(line.startsWith("(51)")){
                if(StringUtils.isEmpty(bean.getFlh())){
                    bean.setFlh(line);
                }else{
                    //保存
                    System.out.println(wgsjzlqsyMapper.save(bean));
                    bean = new Wgsjzlqsy();
                    bean.setFlh(line);
                }
            }else if(line.startsWith("(10)")){
                if(line.contains("CN")){
                    String[] attrs = line.split("CN");
                    bean.setSqggh(attrs[0]);
                    bean.setSqgghv("CN"+attrs[1]);
                }else{
                    bean.setSqggh(line);
                }
            }else if(!StringUtils.isEmpty(bean.getSqggh()) && StringUtils.isEmpty(bean.getSqh()) && StringUtils.isEmpty(bean.getSqgghv())){
                bean.setSqgghv(line);
            }else if(line.startsWith("(21)")){
                bean.setSqh(line);
            }else if(!StringUtils.isEmpty(bean.getSqh()) && StringUtils.isEmpty(bean.getSqrtime()) && StringUtils.isEmpty(bean.getSqhv())){
                bean.setSqhv(line);
            }else if(line.startsWith("(22)")){
                bean.setSqrtime(line);
            }else if(!StringUtils.isEmpty(bean.getSqrtime()) && StringUtils.isEmpty(bean.getSqggr()) && StringUtils.isEmpty(bean.getSqrtimev())){
                bean.setSqrtimev(line);
            }else if(line.startsWith("(45)")){
                bean.setSqggr(line);
            }else if(!StringUtils.isEmpty(bean.getSqggr()) && StringUtils.isEmpty(bean.getZlqr()) && StringUtils.isEmpty(bean.getSqggrv())){
                bean.setSqggrv(line);
            }else if(line.startsWith("(30)")){
                bean.setYxqsj(line);
            }else if(!StringUtils.isEmpty(bean.getYxqsj()) && StringUtils.isEmpty(bean.getZlqr()) && !line.startsWith("(73)")){
                bean.setYxqsjv(line);
            }else if(line.startsWith("(62)")){
                bean.setFaysqsj(line);
            }else if(!StringUtils.isEmpty(bean.getFaysqsj()) && StringUtils.isEmpty(bean.getZlqr()) && !line.startsWith("(73)")){
                bean.setFaysqsjv(line);
            }else if(line.startsWith("(73)")){
                bean.setZlqr(line);
            }else if(!StringUtils.isEmpty(bean.getZlqr()) && StringUtils.isEmpty(bean.getDz()) && StringUtils.isEmpty(bean.getZlqrv())){
                if(line.contains("地址")){
                    String[] attrs = line.split("地址");
                    bean.setZlqrv(attrs[0]);
                    bean.setDz(attrs[1]);
                }else{
                    bean.setZlqrv(line);
                }
            }else if(!StringUtils.isEmpty(bean.getZlqrv()) && StringUtils.isEmpty(bean.getDz()) && !line.startsWith("地址")){
                bean.setZlqrv(bean.getZlqrv()+"\t\t"+line);
            }else if(line.startsWith("地址")){
                bean.setDz(line);
            }else if(!StringUtils.isEmpty(bean.getDz()) && StringUtils.isEmpty(bean.getSjr()) && !line.startsWith("(72)")){
                bean.setDz(bean.getDz()+line);
            }else if(line.startsWith("(72)")){
                bean.setSjr(line);
            }else if(!StringUtils.isEmpty(bean.getSjr()) && StringUtils.isEmpty(bean.getZldljg()) && StringUtils.isEmpty(bean.getSjrv())){
                bean.setSjrv(line);
            }else if(line.startsWith("(74)")){
                bean.setZldljg(line);
            }else if(!StringUtils.isEmpty(bean.getZldljg()) && StringUtils.isEmpty(bean.getMc()) && StringUtils.isEmpty(bean.getZldljgv())){
                bean.setZldljgv(line);
            }else if(!StringUtils.isEmpty(bean.getZldljgv()) && StringUtils.isEmpty(bean.getMc()) && !line.startsWith("(54)")){
                bean.setZldljgv(bean.getZldljgv()+line);
            }else if(line.startsWith("(54)")){
                if(line.contains("LOC")){
                    String[] attr = line.split("LOC");
                    bean.setMc(attr[0].substring(0,attr[0].length()-4));
                    System.out.println(wgsjzlqsyMapper.save(bean));

                    bean = new Wgsjzlqsy();
                    bean.setFlh("(51)LOC"+attr[1]);
                }else{
                    bean.setMc(line);
                }
            }else if(!StringUtils.isEmpty(bean.getMc())){
                bean.setMcv(line);
            }else{
                System.out.println(line);
            }
        }
    }
}
