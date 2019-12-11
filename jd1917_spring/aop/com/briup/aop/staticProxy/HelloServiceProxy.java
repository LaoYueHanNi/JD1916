package com.briup.aop.staticProxy;
//代理类,给目标类添加日志功能
import java.util.Date;

public class HelloServiceProxy implements HelloService{
	private HelloService temp;
	public HelloServiceProxy(HelloService temp) {
		this.temp = temp;
	}
	
	@Override
	public String echo(String msg) {
		System.out.println("echo方法被调用"); //目标方法调前处理
		temp.echo(msg);
		System.out.println("调用之后"); //目标方法调用后处理
		return null;
	}

	@Override
	public Date getTime() {
		return null;
	}

}
