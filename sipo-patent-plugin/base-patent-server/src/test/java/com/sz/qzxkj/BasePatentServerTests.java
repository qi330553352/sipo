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
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BasePatentServerTests {

	@Autowired
	private PatentInfoMapper patentInfoMapper;
	@Autowired
	private PublishTempInfoMapper publishTempInfoMapper;
	@Autowired
	private ApplicantInfoMapper applicantInfoMapper;
	@Autowired
	private PatentLifeInfoMapper patentLifeInfoMapper;
	@Autowired
	private RelationPatentApplicationMapper relationPatentApplicationMapper;

	@Test
	public void contextLoads() throws Exception{
		System.out.println(System.currentTimeMillis());
		List<PatentInfo> list = patentInfoMapper.findAll();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(PatentInfo bean : list){
			PatentLifeInfo info = new PatentLifeInfo();
			info.setPatentInfoId(bean.getId());
			info.setCreateTime(sdf.parse("2019-03-19"));
			info.setRemarks("发明公布");
			patentLifeInfoMapper.save(info);
		}
	}

	@Test
	public void contextLoads1() throws Exception{
		System.out.println(System.currentTimeMillis());
		List<PublishTempInfo> beanList = publishTempInfoMapper.findFullInfo();
		for(PublishTempInfo bean : beanList){
			String names = bean.getApplicationName();
			if(StringUtils.isEmpty(names)) continue;
			List<String> nameList = Arrays.asList(names.split(";"));
			for(String n : nameList){
				if(n.startsWith("?")){
					n = n.substring(1,n.length());
				}
				System.out.println(n);
				ApplicantInfo applicantInfo = applicantInfoMapper.findByApplication(n);
				if(applicantInfo==null){
					applicantInfo = new ApplicantInfo();
					applicantInfo.setApplicationName(n);
					int result = applicantInfoMapper.save(applicantInfo);

					PatentInfo patentInfo = patentInfoMapper.findByPatentno(bean.getPatentno());

					RelationPatentApplication relation = new RelationPatentApplication();
					relation.setApplicantInfoId(applicantInfo.getId());
					relation.setPatentInfoId(patentInfo.getId());
					relationPatentApplicationMapper.save(relation);
				}else{
					PatentInfo patentInfo = patentInfoMapper.findByPatentno(bean.getPatentno());

					RelationPatentApplication relation = relationPatentApplicationMapper.findBean(applicantInfo.getId(),patentInfo.getId());
					if(relation==null){
						relation = new RelationPatentApplication();
						relation.setApplicantInfoId(applicantInfo.getId());
						relation.setPatentInfoId(patentInfo.getId());
						relationPatentApplicationMapper.save(relation);
					}

				}
			}
		}

	}


	@Test
	public void contextLoads2() throws Exception{
		System.out.println(System.currentTimeMillis());
		String path = "D:\\我的文件\\专利数据\\2019.03.19-发明公布.txt";
		InputStreamReader inp = new InputStreamReader(new FileInputStream(new File(path)),"UTF-8");
		BufferedReader reader = new BufferedReader(inp);
		String str = null;
		while ((str = reader.readLine()) != null) {
			String[] list = str.split("\t");
			PublishTempInfo bean = new PublishTempInfo();
			bean.setId(Integer.valueOf(list[0]));
			bean.setPatentno(list[1]);
			bean.setApplicationName(list[2]);
			bean.setPatentName(list[3]);
			publishTempInfoMapper.save(bean);

			PatentInfo patentInfo = new PatentInfo();
			patentInfo.setId(bean.getId());
			patentInfo.setPatentno(bean.getPatentno());
			patentInfo.setPatentName(bean.getPatentName());
			patentInfo.setPatentType(PatentInfo.PatentTypeEnum.PUBLISH.getMessages());
			patentInfoMapper.save(patentInfo);
		}
	}


}
