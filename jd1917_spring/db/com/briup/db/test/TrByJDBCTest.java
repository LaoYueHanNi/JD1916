package com.briup.db.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.db.bean.Student;
import com.briup.db.service.IStudentService;

//���Եײ���JDBC������
public class TrByJDBCTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/db/service/serviceByJDBC.xml","com/briup/db/dao/dao.xml");
		IStudentService service = (IStudentService) ac.getBean("serviceProxy");
		Student stu = new Student(9, "OYW", "2", "xuni", "dasi");
		service.saveStudent(stu);
	}
}
