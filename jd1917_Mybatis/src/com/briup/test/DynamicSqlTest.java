package com.briup.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.bean.Course;
import com.briup.common.MyBatisSqlSessionFactory;
import com.briup.mappers.DynamicSqlMapper;

public class DynamicSqlTest {
	// 测试if
	@Test
	public void searchCourse() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("tutorId", 1);
			map.put("courseName", "%Java%");
			map.put("startDate", new Date());
			DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
			List<Course> courses = mapper.searchCourses(map);
			for (Course course : courses) {
				System.out.println(course);
			}
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	// 测试where
	@Test
	public void searchCourseWhere() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("tutorId", 1);
			map.put("courseName", "%Java%");
			map.put("startDate", new Date());
			DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
			List<Course> courses = mapper.searchCoursesWhere(map);
			for (Course course : courses) {
				System.out.println(course);
			}
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	// 测试trim
	@Test
	public void searchCourseTrim() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("tutorId", 1);
			map.put("courseName", "%Java%");
			// map.put("startDate", new Date());
			DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
			List<Course> courses = mapper.test_trim(map);
			for (Course course : courses) {
				System.out.println(course);
			}
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	// 测试when
	public void test_when() {
		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			Map<String, Object> map = new HashMap<String, Object>();
			// map.put("tutorId", 1);
			map.put("courseName", "%Java%");
			// 输入根据什么类型来查询
			// map.put("searchBy", "Tutor");
			// map.put("searchBy", "CourseName");
			// map.put("startDate", new Date());
			DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
			List<Course> courses = mapper.testWhen(map);
			for (Course course : courses) {
				System.out.println(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 测试foreach
	public void searchCoursesByTutors() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Integer> tutorIds = new ArrayList<Integer>();
		tutorIds.add(1);
		tutorIds.add(3);
		tutorIds.add(6);
		map.put("tutorIds", tutorIds);
		DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		List<Course> courses = mapper.searchCoursesByTutors(map);
		for (Course course : courses) {
			System.out.println(course);
		}
	}
	
	@Test
	public void updateSet() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
			Course course = new Course();
			course.setCourseId(1);
			course.setName("Math");
			course.setDescription("TestUpdate");
			mapper.updateCourse(course);
			session.commit();
		
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
}
