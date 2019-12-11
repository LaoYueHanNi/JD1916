package com.briup.db.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.db.bean.Student;
import com.briup.db.service.IStudentService;

//���Եײ���Mybatis������
public class TrByMybatisTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/db/service/serviceByMybatis2.xml","com/briup/db/mybatisDao/dao.xml");
		//ͨ��Ŀ������ȡ��������(aop:config�ķ�ʽ)
		IStudentService service = (IStudentService) ac.getBean("service");
		Student stu = new Student(13, "dada", "2", "xuni", "dasi");
		service.saveStudent(stu);
	}
}