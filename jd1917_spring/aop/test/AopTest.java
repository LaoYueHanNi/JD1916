package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.aop.bean.Account;
import com.briup.aop.moni.cglib.CglibProxy;
import com.briup.aop.moni.cglib.SayHello;
import com.briup.aop.moni.dynamicProxy.IStudentService;
import com.briup.aop.moni.dynamicProxy.MyHandler;
import com.briup.aop.moni.dynamicProxy.StudentIServiceImpl;
import com.briup.aop.staticProxy.HelloService;
import com.briup.aop.staticProxy.HelloServiceImpl;
import com.briup.aop.staticProxy.HelloServiceProxy;
import com.briup.service.AccountServiceImpl;
import com.briup.service.IAccountService;

public class AopTest {

	//����spring�� ע��
	@Test
	public void test10() {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/aop/annotation/AnnotationHandler.xml");
			//�������
			IAccountService service = (IAccountService) ac.getBean("service");
			Account acc = (Account) ac.getBean("account");
			service.bankAction(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//����spring��Handler
	@Test
	public void test9() {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/service/xmlHandler.xml");
			//�������
			IAccountService service = (IAccountService) ac.getBean("service");
			Account acc = (Account) ac.getBean("account");
			service.bankAction(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//����spring����ǿ��
	@Test
	public void test8() {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/service/adviso.xml");
			//�������
			IAccountService service = (IAccountService) ac.getBean("proxy");
			Account acc = (Account) ac.getBean("account");
			service.bankAction(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//����spring�е��쳣֪ͨ
	@Test
	public void test7() {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/service/throwsAdvice.xml");
			//�������
			IAccountService service = (IAccountService) ac.getBean("proxy");
			Account acc = (Account) ac.getBean("account");
			service.bankAction(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//����spring�еĻ���֪ͨ
	@Test
	public void test6() {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/service/aroundAdvice.xml");
			//�������
			IAccountService service = (IAccountService) ac.getBean("proxy");
			Account acc = (Account) ac.getBean("account");
			service.bankAction(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//����spring�еĺ���֪ͨ
	@Test
	public void test5() {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/service/afterAdvice.xml");
			//�������
			IAccountService service = (IAccountService) ac.getBean("proxy");
			Account acc = (Account) ac.getBean("account");
			service.bankAction(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//����spring�е�ǰ��֪ͨ
	@Test
	public void test4() {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/service/beforeAdvice.xml");
			//�������
			IAccountService service = (IAccountService) ac.getBean("proxy");
			Account acc = (Account) ac.getBean("account");
			service.bankAction(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testCglib() {
		try {
			// ��ȡ�������
			CglibProxy cglib = new CglibProxy();
			SayHello proxy = (SayHello) cglib.getProxy(SayHello.class);
			proxy.say();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test1() {
		try {
			HelloService h1 = new HelloServiceImpl();
			HelloService h2 = new HelloServiceProxy(h1);
			h2.echo("hello");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test2() {
		try {
			IStudentService target = new StudentIServiceImpl();
			target.delete(1);
			target.find(1);
			System.out.println("-----------");
			// ������̬�������
			// ��һ������:�����������������
			// �ڶ�������:���������Ҫʵ�ֵĽӿ�
			//����������:Ŀ�������÷���ʱ����Ҫ�Ĳ���
			//����ֵ:Ŀ�������÷����ķ���ֵ
			ClassLoader loader = target.getClass().getClassLoader();
			Class[] interfaces = target.getClass().getInterfaces();
			InvocationHandler handler = new MyHandler(target);
			IStudentService proxy = (IStudentService) Proxy.newProxyInstance(loader, interfaces, handler);
			proxy.delete(1);
			proxy.find(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
