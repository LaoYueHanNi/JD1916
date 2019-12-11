package com.briup.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.briup.bean.Star;
import com.briup.mappers.StarMapper;

public class StarMapperTest {
	
	@Test
	public void testInsertStar() {
		try {
			InputStream inputStream = org.apache.ibatis.io.Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			StarMapper starMapper = sqlSession.getMapper(StarMapper.class);
			
			Star star = new Star("WLJ", 21, 165, 102);
			starMapper.insertStar(star);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
