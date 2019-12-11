package com.briup.aop.moni.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

//���Բ���Ŀ����Ĵ������
//���һ���������Ŀ��������еķ���
public class CglibProxy implements MethodInterceptor {
	// ���ش������,������Ŀ����
	public Object getProxy(Class clazz) {
		// ���Զ�̬����Ŀ�����Ĵ������
		Enhancer enhancer = new Enhancer();
		// ����˭�Ǹ���
		enhancer.setSuperclass(clazz);
		// ����ס�÷������õķ�����˭
		// this����ǰ���intercept����
		enhancer.setCallback(this);
		// ͨ���ֽ��뼼����̬��������ʵ��
		return enhancer.create();
	}

	// ��һ������:���������������
	// �ڶ�������:���ص�Ŀ����ķ���
	// ����������:���÷�������Ҫ�Ĳ���
	// ���ĸ�����:Ϊ������(����)�з����ķ������
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy mproxy) throws Throwable {
		System.out.println(method.getName() + "��������������");
		// ����Ŀ������еõ�����
		// Method.invoke(obj,args)
		Object result = mproxy.invoke(proxy, args);
		System.out.println(method.getName() + "�����Ѿ�������");
		return result;
	}

}
