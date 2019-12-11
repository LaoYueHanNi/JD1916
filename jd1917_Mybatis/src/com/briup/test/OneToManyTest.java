package com.briup.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.bean.Tutor;
import com.briup.common.MyBatisSqlSessionFactory;
import com.briup.mappers.One2ManyMapper;

public class OneToManyTest {
	@Test
	public void TestListTutors() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			One2ManyMapper mapper = session.getMapper(One2ManyMapper.class);
			List<Tutor> list = mapper.listTutorsWithCourse();
			for (Tutor temp : list) {
				System.out.println(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void findTutorWithCourseTest() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			One2ManyMapper mapper = session.getMapper(One2ManyMapper.class);
			Tutor t = mapper.findTutorById(2);
			System.out.println(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

