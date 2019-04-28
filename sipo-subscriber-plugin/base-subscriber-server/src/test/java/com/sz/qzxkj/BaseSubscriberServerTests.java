package com.sz.qzxkj;

import com.sz.qzxkj.entity.DepartmentInfo;
import com.sz.qzxkj.entity.RelationUserRole;
import com.sz.qzxkj.entity.RoleInfo;
import com.sz.qzxkj.entity.UserInfo;
import com.sz.qzxkj.mapper.DepartmentInfoMapper;
import com.sz.qzxkj.mapper.RelationUserRoleMapper;
import com.sz.qzxkj.mapper.RoleInfoMapper;
import com.sz.qzxkj.mapper.UserInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseSubscriberServerTests {

	@Autowired
	private RoleInfoMapper mapper;
	@Autowired
	private UserInfoMapper userInfomapper;
	@Autowired
	private RelationUserRoleMapper userRoleMapper;

	@Test
	public void contextLoads() {
		System.out.println("\r\n");
		System.out.println("\r\n");
		Set<UserInfo> users = new HashSet<>();
		UserInfo user = userInfomapper.findById(3);
		users.add(user);
		RoleInfo role = new RoleInfo();
		role.setRoleName("职员");
		role.setRemark("很可爱");
		role.setUsers(users);
		mapper.save(role);
		RelationUserRole userRole = new RelationUserRole();
		userRole.setUserInfoId(user.getId());
		userRole.setRoleInfoId(role.getId());
		userRoleMapper.save(userRole);
	}

}
