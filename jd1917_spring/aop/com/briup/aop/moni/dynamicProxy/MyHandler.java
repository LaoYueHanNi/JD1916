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
		System.out.println(method.getName()+"���ϱ�������");
		//����Ŀ�����ķ���
		//Ŀ�����ȡ���������ҵ���߼��Ĵ���
		Object result = method.invoke(target, args);
		System.out.println(method.getName()+"���ý�����");
		return null;
	}

}
