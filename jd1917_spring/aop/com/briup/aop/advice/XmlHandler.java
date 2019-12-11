package com.briup.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

//ʹ�������ļ��������������֪ͨ
//����Ҫʵ���κεĽӿ�
public class XmlHandler {
	// ��������Ŀ�������÷���֮ǰ����
	// JoinPoint����ľ������ӵ�Ķ���
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
