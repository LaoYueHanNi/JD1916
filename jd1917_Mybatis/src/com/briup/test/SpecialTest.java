package com.briup.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.bean.Gender;
import com.briup.bean.User;
import com.briup.bean.UserPic;
import com.briup.common.MyBatisSqlSessionFactory;
import com.briup.mappers.SpecialMapper;

public class SpecialTest {
	// 测试mybatis对枚举类型的支持
	@Test
	public void addUser() {
		try {
			SqlSession session = MyBatisSqlSessionFactory.openSession();
			User user = new User("tom", Gender.MALE);
			SpecialMapper mapper = session.getMapper(SpecialMapper.class);
			mapper.insertUser(user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 测试mybatis对枚举类型的支持
	@Test
	public void findUser() {
		try {
			SqlSession session = MyBatisSqlSessionFactory.openSession();
			SpecialMapper mapper = session.getMapper(SpecialMapper.class);
			List<User> list = mapper.selectUser();
			for (User temp : list)
				System.out.println(temp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 测试mybatis处理CLOB/BLOB类型数据 保存数据
	@Test
	public void addUserpic() {
		byte[] pic = null;
		try {
			// 读取用户头像图片
			File file = new File("src/com/briup/bean/test.png");
			InputStream is = new FileInputStream(file);
			pic = new byte[is.available()];
			is.read(pic);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String name = "tom";
		String bio = "可以是很长的字符串";
		// 准备好要插入到数据库中的数据并封装成对象
		UserPic userPic = new UserPic(name, pic, bio);

		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			SpecialMapper mapper = session.getMapper(SpecialMapper.class);
			mapper.insertUserPic(userPic);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	// 测试mybatis处理CLOB/BLOB类型数据
	// 查询出数据
	@Test
	public void test_getUserPicById() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			SpecialMapper mapper = session.getMapper(SpecialMapper.class);
			UserPic userPic = mapper.getUserPicById(65);
			System.out.println(userPic.getId());
			System.out.println(userPic.getName());
			System.out.println(userPic.getBio());
			System.out.println(userPic.getPic().length);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	// 测试mybatis多行结果集映射成Map
	@Test
	public void test_findAllUsers() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			// 不能使用接口的方式
			/*
			 * Map<Integer, User> map=session.selectMap(
			 * "com.briup.mappers.SpecialMapper.findAllUsers","id"); for(Integer
			 * key:map.keySet()){ System.out.println(key+":"+map.get(key)); }
			 */

			Map<String, User> map = session.selectMap("com.briup.mappers.SpecialMapper.findAllUsers", "id");
			for (String key : map.keySet()) {
				System.out.println(key + " : " + map.get(key));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	// 测试mybatis使用RowBounds对结果集进行分页
	@Test
	public void test_findAllUsersBySort() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			SpecialMapper mapper = session.getMapper(SpecialMapper.class);
			int currPage = 2;// 当前页
			int limit = 3;//每一页显示的行数
			int offset = (currPage - 1) * limit;//偏移量
			RowBounds row = new RowBounds(offset, limit);
			List<User> list = mapper.findAllUsers(row);
			for (User u : list) {
				System.out.println(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	// 测试mybatis使用rowNum对结果集进行分页
	@Test
	public void test_findUsersBySort() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			SpecialMapper mapper = session.getMapper(SpecialMapper.class);
			int currPage = 2;
			int limit = 3;
			int offset = (currPage - 1) * limit;
			List<User> list = mapper.findUserByRow(currPage * limit, offset);
			for (User u : list) {
				System.out.println(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	// 测试mybatis使用ResultSetHandler
	// 自定义结果集ResultSet处理
	@Test
	public void test_ResultHandler() {
		final Map<Integer, String> map = new HashMap<Integer, String>();
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();

			session.select("com.briup.mappers.SpecialMapper.findAllUsers", new ResultHandler<User>() {
				@Override
				public void handleResult(ResultContext<? extends User> resultContext) {
					User user = resultContext.getResultObject();
					map.put(user.getId(), user.getName());
				}
			});

			for (Integer key : map.keySet()) {
				System.out.println(key + " : " + map.get(key));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	// 测试mybatis缓存 一级缓存
	@Test
	public void test_cache1() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();

			SpecialMapper mapper = session.getMapper(SpecialMapper.class);

			User user1 = mapper.findUserById(64);
			System.out.println(user1);
			session.commit();

			User user2 = mapper.findUserById(64);
			System.out.println(user2);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	// 测试mybatis缓存 二级缓存
	@Test
	public void test_cache2() {
		SqlSession session1 = null;
		SqlSession session2 = null;
		try {
			session1 = MyBatisSqlSessionFactory.openSession();
			session2 = MyBatisSqlSessionFactory.openSession();

			SpecialMapper mapper1 = session1.getMapper(SpecialMapper.class);
			SpecialMapper mapper2 = session2.getMapper(SpecialMapper.class);

			User user1 = mapper1.findUserById(65);
			System.out.println(user1);
			session1.commit();

			User user2 = mapper2.findUserById(65);
			System.out.println(user2);
			session2.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session1 != null)
				session1.close();
			if (session2 != null)
				session2.close();
		}
	}
}
