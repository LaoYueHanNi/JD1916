package com.briup.test;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.bean.Mi;
import com.briup.common.MyBatisSqlSessionFactory;
import com.briup.mappers.MiMapper;

public class MiTest {

	@Test
	public void testSelect() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			MiMapper mapper = session.getMapper(MiMapper.class);
			List<Mi> list = mapper.selectAllMi();
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsert() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			MiMapper mapper = session.getMapper(MiMapper.class);
			Mi mi = new Mi(2, "mi2", "40000");
			mapper.insertMi(mi);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteById() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			MiMapper mapper = session.getMapper(MiMapper.class);
			mapper.deleteMi(1);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateMi() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			MiMapper mapper = session.getMapper(MiMapper.class);
			Mi mi = new Mi(2, "mi2", "40000");
			mapper.updateMi(mi);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
