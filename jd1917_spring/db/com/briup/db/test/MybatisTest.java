package com.briup.db.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.db.bean.Student;
import com.briup.db.mybatisDao.IStudentDao;

public class MybatisTest {
	@Test
	public void test() {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/db/mybatisDao/dao.xml");
			//获取IStudentDao接口的对象
			IStudentDao dao = ac.getBean(IStudentDao.class);
			Student stu = new Student(19,"kris","boy","xuni","three");
			dao.addStudent(stu);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
