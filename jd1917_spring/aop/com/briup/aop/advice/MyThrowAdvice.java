package com.briup.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

import com.briup.aop.aspect.MyLog;

public class MyThrowAdvice implements ThrowsAdvice{
	private MyLog log;
	public void setLogger(MyLog log) {
		this.log = log;
	}
	public void afterThrowing(Exception e) {
		log.log("“Ï≥£¡À");
	}


}
