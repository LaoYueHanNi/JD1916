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

//������
public class StudentTest {

	@Test
	public void deleteAllStudents() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			mapper.deleteAllStudents();
			session.commit();// �ύ����

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
		}
	}

	// ���Ը���id�Ÿ���ĳһ��ѧ������Ϣ
	@Test
	public void updateStuById() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			Student stu = new Student(1, "zhangsan", "zhangsan@163.com", null);
			mapper.updateStudentById(stu);
			session.commit();// �ύ����

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
		}
	}

	// ���Ը���id�Ų�ѯĳһ��ѧ������Ϣ
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
			// �ر���Դ
		}
	}

	// ���Բ�ѯ����ѧ������Ϣ
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
			// �ر���Դ
		}
	}

	// �����ݿ���в���һ��Student����
	@Test
	public void addStu() {
		try {
			// 1)����SqlSessionFactory����
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			// 2)����SqlSession����
			SqlSession session = factory.openSession();
			// 3)����ӳ��ӿ�ʵ����StudentMapper�Ķ���
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			// 4)����ӳ��ӿ�ʵ����ķ���������ִ��sql���
			Student stu = new Student(5, "WMM", "mack@163.com", new Date());
			mapper.insertStudent(stu);
			// 5)�ֶ��ύ����
			session.commit();
			// 6)�ر���Դ
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
			//�ڶ���
			session.insert("com.briup.mappers.StudentMapper.insertStudentAndPhone", stu);
			
			//��һ��
//			StudentMapper mapper = session.getMapper(StudentMapper.class);
//			PhoneNumber p = new PhoneNumber("11", "13", "18712314432");
//			Student stu = new Student(1, "WLJ", "55.com", new Date(),p);
//			mapper.insertStudentAndPhone(stu);
//			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
		}
	}
}
