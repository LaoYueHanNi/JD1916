package com.briup.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.briup.aop.aspect.MyLog;

public class AroundAdvice implements MethodInterceptor {

	private MyLog log;

	public void setLog(MyLog log) {
		this.log = log;
	}

	// ���������÷���ʱ����
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		String name = mi.getMethod().getName();
		log.log(name + " ����ִ��֮ǰ");
		//����Ŀ�����ķ���
		Object result = mi.proceed();
		log.log(name + "����ִ��֮��");
		return result;
	}

}
