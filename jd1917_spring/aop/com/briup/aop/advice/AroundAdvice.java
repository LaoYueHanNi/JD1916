package com.briup.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.briup.aop.aspect.MyLog;

public class AroundAdvice implements MethodInterceptor {

	private MyLog log;

	public void setLog(MyLog log) {
		this.log = log;
	}

	// 代理对象调用方法时触发
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		String name = mi.getMethod().getName();
		log.log(name + " 方法执行之前");
		//调用目标对象的方法
		Object result = mi.proceed();
		log.log(name + "方法执行之后");
		return result;
	}

}
