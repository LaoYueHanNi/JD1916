package com.briup.db.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.db.bean.Student;
import com.briup.db.dao.IStudentDao;

public class DbTest {
	@Test
		public void test1() {
			try {
				ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/db/dao/dao.xml");
				IStudentDao dao = (IStudentDao) ac.getBean("stuDaoImp");
				List list = dao.selectStudents();
				System.out.println(list);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	@Test
	public void test2() {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/db/dao/daoByJDBCTemp.xml");
			IStudentDao dao = (IStudentDao) ac.getBean("stuDaoImp");
			List<Student> list = dao.selectStudents();
			System.out.println(list);
			System.out.println("----------");
			Student stu = dao.selectStudentById(2);
			System.out.println(stu);
			System.out.println("----------");
			Student stu2 = new Student(1,"xigha", "ÄÐ", "ÐéÄâ", "´óËÄ");
			//dao.addStudent(stu2);
			System.out.println("---------");
			//dao.deleteStudentById(1);
		}catch(Exception e) {
			e.printStackTrace(); 
		}
	}
}
