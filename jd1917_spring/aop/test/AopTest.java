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

	//测试spring中 注解
	@Test
	public void test10() {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/aop/annotation/AnnotationHandler.xml");
			//代理对象
			IAccountService service = (IAccountService) ac.getBean("service");
			Account acc = (Account) ac.getBean("account");
			service.bankAction(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//测试spring中Handler
	@Test
	public void test9() {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/service/xmlHandler.xml");
			//代理对象
			IAccountService service = (IAccountService) ac.getBean("service");
			Account acc = (Account) ac.getBean("account");
			service.bankAction(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//测试spring中增强器
	@Test
	public void test8() {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/service/adviso.xml");
			//代理对象
			IAccountService service = (IAccountService) ac.getBean("proxy");
			Account acc = (Account) ac.getBean("account");
			service.bankAction(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//测试spring中的异常通知
	@Test
	public void test7() {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/service/throwsAdvice.xml");
			//代理对象
			IAccountService service = (IAccountService) ac.getBean("proxy");
			Account acc = (Account) ac.getBean("account");
			service.bankAction(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//测试spring中的环绕通知
	@Test
	public void test6() {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/service/aroundAdvice.xml");
			//代理对象
			IAccountService service = (IAccountService) ac.getBean("proxy");
			Account acc = (Account) ac.getBean("account");
			service.bankAction(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//测试spring中的后置通知
	@Test
	public void test5() {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/service/afterAdvice.xml");
			//代理对象
			IAccountService service = (IAccountService) ac.getBean("proxy");
			Account acc = (Account) ac.getBean("account");
			service.bankAction(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//测试spring中的前置通知
	@Test
	public void test4() {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/service/beforeAdvice.xml");
			//代理对象
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
			// 获取代理对象
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
			// 产生动态代理对象
			// 第一个参数:定义代理类的类加载器
			// 第二个参数:定义代理类要实现的接口
			//第三个参数:目标对象调用方法时所需要的参数
			//返回值:目标对象的用方法的返回值
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
