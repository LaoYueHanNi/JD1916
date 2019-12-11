package com.briup.aop.staticProxy;
//������,��Ŀ���������־����
import java.util.Date;

public class HelloServiceProxy implements HelloService{
	private HelloService temp;
	public HelloServiceProxy(HelloService temp) {
		this.temp = temp;
	}
	
	@Override
	public String echo(String msg) {
		System.out.println("echo����������"); //Ŀ�귽����ǰ����
		temp.echo(msg);
		System.out.println("����֮��"); //Ŀ�귽�����ú���
		return null;
	}

	@Override
	public Date getTime() {
		return null;
	}

}
