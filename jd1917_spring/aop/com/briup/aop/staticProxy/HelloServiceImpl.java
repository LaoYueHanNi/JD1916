package com.briup.aop.staticProxy;

import java.util.Date;

public class HelloServiceImpl implements HelloService {

	@Override
	public String echo(String msg) {
		System.out.println("ί�������"+msg);
		return null;
	}

	@Override
	public Date getTime() {
		return null;
	}

}
