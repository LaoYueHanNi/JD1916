package com.briup.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.bean.Address;
import com.briup.bean.PhoneNumber;
import com.briup.bean.Student;
import com.briup.common.MyBatisSqlSessionFactory;
import com.briup.mappers.One2OneMapper;

public class One2OneTest {
	
	//Ƕ�׽��
	@Test
	public void testStuById() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			One2OneMapper mapper = session.getMapper(One2OneMapper.class);
			Student stu = mapper.findStuByIdWithAddress(1);
			System.out.println(stu);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAllStu() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			One2OneMapper mapper = session.getMapper(One2OneMapper.class);
			List<Student> list = mapper.findStuWithAddress();
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//-----------------------
	
	// Ƕ�ײ�ѯ
	@Test
	public void testAllStu2() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			One2OneMapper mapper = session.getMapper(One2OneMapper.class);
			List<Student> list = mapper.ListStusWIthAddress();
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//  Ƕ�ײ���
	@Test
	public void test_addStu() {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			One2OneMapper mapper = session.getMapper(One2OneMapper.class);
			Address address = new Address("ѧԺ·", "�ͳ�", "��ɽ", "12", "�й�");
			Student student = new Student("����", "zs@qq.com", new Date(), new PhoneNumber("2","1","1"));
			student.setAddress(address);
			mapper.insertAddress(address);
			mapper.insertStudent(student);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
