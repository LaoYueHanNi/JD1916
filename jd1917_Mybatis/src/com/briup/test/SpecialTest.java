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
	// ����mybatis��ö�����͵�֧��
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

	// ����mybatis��ö�����͵�֧��
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

	// ����mybatis����CLOB/BLOB�������� ��������
	@Test
	public void addUserpic() {
		byte[] pic = null;
		try {
			// ��ȡ�û�ͷ��ͼƬ
			File file = new File("src/com/briup/bean/test.png");
			InputStream is = new FileInputStream(file);
			pic = new byte[is.available()];
			is.read(pic);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String name = "tom";
		String bio = "�����Ǻܳ����ַ���";
		// ׼����Ҫ���뵽���ݿ��е����ݲ���װ�ɶ���
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

	// ����mybatis����CLOB/BLOB��������
	// ��ѯ������
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

	// ����mybatis���н����ӳ���Map
	@Test
	public void test_findAllUsers() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			// ����ʹ�ýӿڵķ�ʽ
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

	// ����mybatisʹ��RowBounds�Խ�������з�ҳ
	@Test
	public void test_findAllUsersBySort() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			SpecialMapper mapper = session.getMapper(SpecialMapper.class);
			int currPage = 2;// ��ǰҳ
			int limit = 3;//ÿһҳ��ʾ������
			int offset = (currPage - 1) * limit;//ƫ����
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

	// ����mybatisʹ��rowNum�Խ�������з�ҳ
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

	// ����mybatisʹ��ResultSetHandler
	// �Զ�������ResultSet����
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

	// ����mybatis���� һ������
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

	// ����mybatis���� ��������
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
