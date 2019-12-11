package com.briup.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.briup.bean.PhoneNumber;
import com.briup.bean.Student;
import com.briup.common.MyBatisSqlSessionFactory;
import com.briup.mappers.StudentMapper;

//测试类
public class StudentTest {

	@Test
	public void deleteAllStudents() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			mapper.deleteAllStudents();
			session.commit();// 提交事务

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
		}
	}

	// 测试根据id号更新某一个学生的信息
	@Test
	public void updateStuById() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			Student stu = new Student(1, "zhangsan", "zhangsan@163.com", null);
			mapper.updateStudentById(stu);
			session.commit();// 提交事务

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
		}
	}

	// 测试根据id号查询某一个学生的信息
	@Test
	public void findStuById() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			Student stu = mapper.findStudentById(1);
			System.out.println(stu);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
		}
	}

	// 测试查询所有学生的信息
	@Test
	public void listAllStus() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			List<Student> list = mapper.findAllStudents();

			for (Student stu : list) {
				System.out.println(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
		}
	}

	// 向数据库表中插入一个Student对象
	@Test
	public void addStu() {
		try {
			// 1)创建SqlSessionFactory对象
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			// 2)创建SqlSession对象
			SqlSession session = factory.openSession();
			// 3)创建映射接口实现类StudentMapper的对象
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			// 4)调用映射接口实现类的方法，等于执行sql语句
			Student stu = new Student(5, "WMM", "mack@163.com", new Date());
			mapper.insertStudent(stu);
			// 5)手动提交事务
			session.commit();
			// 6)关闭资源
			if (session != null)
				session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void addStudentAndPhone() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			PhoneNumber p = new PhoneNumber("11", "13", "18712314432");
			Student stu = new Student("WLJ", "55.com", new Date(),p);
			//第二种
			session.insert("com.briup.mappers.StudentMapper.insertStudentAndPhone", stu);
			
			//第一种
//			StudentMapper mapper = session.getMapper(StudentMapper.class);
//			PhoneNumber p = new PhoneNumber("11", "13", "18712314432");
//			Student stu = new Student(1, "WLJ", "55.com", new Date(),p);
//			mapper.insertStudentAndPhone(stu);
//			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
		}
	}
}
