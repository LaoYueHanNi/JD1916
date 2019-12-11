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
	//测试自动注入
	@Test
	public void test3() {
		try {
			ApplicationContext container = new ClassPathXmlApplicationContext("com/briup/ioc/autowire/autowire.xml");
			Student s = (Student) container.getBean("s2");
			System.out.println(s);
			//输出s对象在配置文件中那么或者id的值
			System.out.println(s.getName());
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}
		//测试bean生命周期
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
		//测试工厂类
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
		//测试实例工厂类
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
		//测试静态工厂类
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
		//测试属性转换器
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
		//测试事件监听器
		@Test
		public void test9() {
			try {
				ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("com/briup/ioc/event/event.xml");
				//发布事件
				RainEvent event = new RainEvent("下雨了");
				container.publishEvent(event);
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//测试 注解
		@Test
		public void test10() {
			try {
				ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("com/briup/ioc/annotation/annotation.xml");
				//发布事件
				Boss b = (Boss) container.getBean("boss");
				System.out.println(b);
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
