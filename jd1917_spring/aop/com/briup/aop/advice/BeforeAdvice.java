package com.briup.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.briup.aop.aspect.MyLog;

//前置通知
public class BeforeAdvice implements MethodBeforeAdvice {

	private MyLog log;
	public void setLog(MyLog log) {
		this.log=log;
	}
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		log.log(arg0.getName()+"被调用");
	}
	
}
