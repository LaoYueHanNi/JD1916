package com.briup.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.bean.Student;
import com.briup.common.MyBatisSqlSessionFactory;
import com.briup.mappers.ResultMapper;

public class ResultTest {
	@Test
	public void listAllStus() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			ResultMapper mapper = session.getMapper(ResultMapper.class);
			List<Student> list = mapper.listStus();

			for (Student stu : list) {
				System.out.println(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
		}
	}

	@Test
	public void listName() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			ResultMapper mapper = session.getMapper(ResultMapper.class);
			List<String> list = mapper.listName();

			for (String stu : list) {
				System.out.println(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
		}
	}

	@Test
	public void findStuById_map() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			ResultMapper mapper = session.getMapper(ResultMapper.class);
			Map<String, Object> map = mapper.findStuById_map(1);

			System.out.println(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
		}
	}

	public void findStuById_mapList() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			ResultMapper mapper = session.getMapper(ResultMapper.class);
			List<Map<String, Object>> list = mapper.findStuById_mapList();
			
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
		}
	}
	
	public void test_map() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			Map<String,Student> map = session.selectMap("com.briup.mappers.ResultMapper.sql���ı�ǩ��", "name");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
}
