package com.briup.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.birup.bean.Group;
import com.birup.bean.User;
import com.briup.common.MyBatisSqlSessionFactory;
import com.briup.mappers.GroupAndUserMapper;

public class UserAndGroupTest {
	
	@Test
	public void testInsertGroup() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			GroupAndUserMapper mapper = session.getMapper(GroupAndUserMapper.class);
			Group group = new Group(1,"����");
			mapper.insertGroup(group);
			session.commit();// �ύ����

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
		}
	}
	@Test
	public void testInsertUser() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			GroupAndUserMapper mapper = session.getMapper(GroupAndUserMapper.class);
			User user = new User("zs", 16, 1);
			mapper.insertUser(user);
			session.commit();// �ύ����

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
		}
	}
	@Test
	public void testSelectGroupWithUser() {
		SqlSession session = null; 
		try {
			session = MyBatisSqlSessionFactory.openSession();
			GroupAndUserMapper mapper = session.getMapper(GroupAndUserMapper.class);
			
			List<Group> list = mapper.findGroupWithUser();
			
			System.out.println(list);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
		}
	}
	
}
