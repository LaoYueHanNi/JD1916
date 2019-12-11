package com.briup.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

import com.briup.aop.aspect.MyLog;

//正常执行结束后执行的通知
public class MyAfterAdvice implements AfterReturningAdvice{
	
	private MyLog log;
	public void setLog(MyLog log) {
		this.log=log;
	}
	
	//该方法在目标方法正常执行结束之后调用
	@Override
	public void afterReturning(Object returning, Method method, Object[] arg2, Object arg3) throws Throwable {
		log.log(method.getName()+"方法正常执行结束,该方法的返回值是"+returning);
	}

}
