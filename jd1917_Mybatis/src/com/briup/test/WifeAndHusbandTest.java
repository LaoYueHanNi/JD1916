package com.briup.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.bean.Husband;
import com.briup.bean.Wife;
import com.briup.common.MyBatisSqlSessionFactory;
import com.briup.mappers.WifeAndHusbandMapper;

public class WifeAndHusbandTest {
	@Test
	public void insertHusbandAndWife() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			WifeAndHusbandMapper mapper = session.getMapper(WifeAndHusbandMapper.class);
			Husband h = new Husband(" 张先生", 23);
			Wife w = new Wife("马小姐", 21);
			w.setHusband(h);
			mapper.insertHusband(h);
			mapper.insertWife(w);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void selectHusbandAndWife() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			WifeAndHusbandMapper mapper = session.getMapper(WifeAndHusbandMapper.class);
			Wife w = mapper.selectWifeAndHusband(2);
			System.out.println(w);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		@Test
		public void findWife() {
			SqlSession session = null;
			try {
				session = MyBatisSqlSessionFactory.openSession();
				WifeAndHusbandMapper mapper = session.getMapper(WifeAndHusbandMapper.class);
				Wife w = mapper.findWife(2);
				System.out.println(w);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
