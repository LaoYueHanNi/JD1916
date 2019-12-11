package com.briup.aop.moni.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler{
	
	private IStudentService target;
	public MyHandler(IStudentService target) {
		this.target=target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(method.getName()+"马上被调用了");
		//调用目标对象的方法
		//目标对象取真正的完成业务逻辑的代码
		Object result = method.invoke(target, args);
		System.out.println(method.getName()+"调用结束了");
		return null;
	}

}
