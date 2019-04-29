package com.sz.qzxkj;

import com.sz.qzxkj.design.proxy.TransactionalProxy;
import com.sz.qzxkj.design.proxy.TransactionalProxyHandler;
import com.sz.qzxkj.design.proxy.TransactionalProxyImpl;
import com.sz.qzxkj.mapper.RelationUserRoleMapper;
import com.sz.qzxkj.mapper.RoleInfoMapper;
import com.sz.qzxkj.mapper.UserInfoMapper;
import com.sz.qzxkj.service.TransactionalService;
import org.assertj.core.api.ProxyablePredicateAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseSubscriberServerTests {

	@Autowired
	private RoleInfoMapper mapper;
	@Autowired
	private UserInfoMapper userInfomapper;
	@Autowired
	private RelationUserRoleMapper userRoleMapper;
	@Autowired
	private TransactionalService service;
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Test
	@Transactional
	public void contextLoads() {

		log.info("----------------------");
		log.info("--------start--------------");
		log.info("----------------------");
//		System.out.println("\r\n");
//		System.out.println("\r\n");
//		Set<UserInfo> users = new HashSet<>();
//		UserInfo user = userInfomapper.findById(3);
//		users.add(user);
//		RoleInfo role = new RoleInfo();
//		role.setRoleName("职员1");
//		role.setRemark("很可爱1");
//		role.setUsers(users);
//		mapper.save(role);
//		RelationUserRole userRole = new RelationUserRole();
//		userRole.setUserInfoId(user.getId());
//		userRole.setRoleInfoId(role.getId());
//		userRoleMapper.save(userRole);
//		int a = 1/0;
		service.parent();
	}

	@Test
	public void test2(){
		TransactionalProxy proxyImpl = new TransactionalProxyImpl();
		TransactionalProxyHandler handler = new TransactionalProxyHandler(proxyImpl);
		TransactionalProxy proxy = (TransactionalProxy) Proxy.newProxyInstance(TransactionalProxyHandler.class.getClassLoader(),new Class[]{TransactionalProxy.class},handler);
		log.info("代理对象:"+proxy.getClass().getName());
		proxy.test1();
		proxy.test2();
	}

}
