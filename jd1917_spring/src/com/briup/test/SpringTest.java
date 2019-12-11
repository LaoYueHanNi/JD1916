package com.briup.test;

import java.sql.Connection;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.bean.LifeBean;
import com.briup.bean.Teacher;
import com.briup.db.bean.Student;
import com.briup.ioc.annotation.Boss;
import com.briup.ioc.event.RainEvent;

public class SpringTest {
	
	@Test
	public void test() {
		try {
			ApplicationContext container = new ClassPathXmlApplicationContext("com/briup/ioc/set/set.xml","com/briup/ioc/set/set2.xml");
			Student s = (Student) container.getBean("stu");
			System.out.println(s);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test2() {
		try {
			ApplicationContext container = new ClassPathXmlApplicationContext("com/briup/ioc/set/constrcutor.xml");
			Teacher t = (Teacher) container.getBean("teacher");
			System.out.println(t);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�����Զ�ע��
	@Test
	public void test3() {
		try {
			ApplicationContext container = new ClassPathXmlApplicationContext("com/briup/ioc/autowire/autowire.xml");
			Student s = (Student) container.getBean("s2");
			System.out.println(s);
			//���s�����������ļ�����ô����id��ֵ
			System.out.println(s.getName());
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}
		//����bean��������
		@Test
		public void test4() {
			try {
				ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("com/briup/ioc/set/Life.xml");
				LifeBean life1 = (LifeBean) container.getBean("lifebean");
				System.out.println(life1);
				container.destroy();
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		//���Թ�����
		@Test
		public void test5() {
			try {
				ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("com/briup/factory/Factory.xml");
				Connection conn = (Connection) container.getBean("conn");
				System.out.println(conn);
			
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//����ʵ��������
		@Test
		public void test6() {
			try {
				ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("com/briup/ioc/instanceFactory/Factory.xml");
				Connection conn = (Connection) container.getBean("conn");
				System.out.println(conn);
				
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//���Ծ�̬������
		@Test
		public void test7() {
			try {
				ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("com/briup/ioc/staticFactory/Factory.xml");
				Connection conn = (Connection) container.getBean("conn");
				System.out.println(conn);
				
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//��������ת����
		@Test
		public void test8() {
			try {
				ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("com/briup/ioc/proEdit/proEdit.xml");
				Student s = (Student) container.getBean("stu");
				System.out.println(s);
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//�����¼�������
		@Test
		public void test9() {
			try {
				ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("com/briup/ioc/event/event.xml");
				//�����¼�
				RainEvent event = new RainEvent("������");
				container.publishEvent(event);
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//���� ע��
		@Test
		public void test10() {
			try {
				ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("com/briup/ioc/annotation/annotation.xml");
				//�����¼�
				Boss b = (Boss) container.getBean("boss");
				System.out.println(b);
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
