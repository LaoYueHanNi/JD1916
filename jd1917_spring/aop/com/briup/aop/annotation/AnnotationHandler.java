package com.briup.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//使用配置文件来定义切面类的通知
//不需要实现任何的接口
@Component
@Aspect  //切面对象的注解

public class AnnotationHandler{
	
	@Pointcut("execution(* com.briup.service.*.*(..))")
	public void myPointCut(){}
	
	// 想让他在目标对象调用方法之前调用
	// JoinPoint代表的就是连接点的对象
	@Before("")
	public void before(JoinPoint jp) {
		System.out.println("日志:" + jp.getSignature().getName() + "方法即将被调用,before...");
	}

	public void after(JoinPoint jp) {
		System.out.println("日志:" + jp.getSignature().getName() + "方法调用结束,after...");
	}

	// ProceedingJoinPoint可以调用该连接点所对应的方法
	public Object aroun(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("环绕通知前");
		Object result = pjp.proceed();// 调用连接点的方法
		System.out.println("环绕通知后");
		return result;
	}
	public void throwing(JoinPoint jp) {
		System.out.println("日志:" + jp.getSignature().getName() + "抛出异常");
	}
}
