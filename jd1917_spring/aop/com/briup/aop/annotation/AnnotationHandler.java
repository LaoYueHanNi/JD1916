package com.briup.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//ʹ�������ļ��������������֪ͨ
//����Ҫʵ���κεĽӿ�
@Component
@Aspect  //��������ע��

public class AnnotationHandler{
	
	@Pointcut("execution(* com.briup.service.*.*(..))")
	public void myPointCut(){}
	
	// ��������Ŀ�������÷���֮ǰ����
	// JoinPoint����ľ������ӵ�Ķ���
	@Before("")
	public void before(JoinPoint jp) {
		System.out.println("��־:" + jp.getSignature().getName() + "��������������,before...");
	}

	public void after(JoinPoint jp) {
		System.out.println("��־:" + jp.getSignature().getName() + "�������ý���,after...");
	}

	// ProceedingJoinPoint���Ե��ø����ӵ�����Ӧ�ķ���
	public Object aroun(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("����֪ͨǰ");
		Object result = pjp.proceed();// �������ӵ�ķ���
		System.out.println("����֪ͨ��");
		return result;
	}
	public void throwing(JoinPoint jp) {
		System.out.println("��־:" + jp.getSignature().getName() + "�׳��쳣");
	}
}
