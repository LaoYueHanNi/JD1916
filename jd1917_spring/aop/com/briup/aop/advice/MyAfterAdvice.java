package com.briup.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

import com.briup.aop.aspect.MyLog;

//����ִ�н�����ִ�е�֪ͨ
public class MyAfterAdvice implements AfterReturningAdvice{
	
	private MyLog log;
	public void setLog(MyLog log) {
		this.log=log;
	}
	
	//�÷�����Ŀ�귽������ִ�н���֮�����
	@Override
	public void afterReturning(Object returning, Method method, Object[] arg2, Object arg3) throws Throwable {
		log.log(method.getName()+"��������ִ�н���,�÷����ķ���ֵ��"+returning);
	}

}
