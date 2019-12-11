package com.briup.aop.moni.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

//可以产生目标类的代理对象
//并且还可以拦截目标类的所有的方法
public class CglibProxy implements MethodInterceptor {
	// 返回代理对象,参数是目标类
	public Object getProxy(Class clazz) {
		// 可以动态生成目标对象的代理对象
		Enhancer enhancer = new Enhancer();
		// 设置谁是父类
		enhancer.setSuperclass(clazz);
		// 拦截住该方法调用的方法是谁
		// this代表当前类的intercept方法
		enhancer.setCallback(this);
		// 通过字节码技术动态创建子类实例
		return enhancer.create();
	}

	// 第一个参数:即将产生代理对象
	// 第二个参数:拦截到目标类的方法
	// 第三个参数:调用方法所需要的参数
	// 第四个参数:为代理类(子类)中方法的反射对象
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy mproxy) throws Throwable {
		System.out.println(method.getName() + "方法即将被调用");
		// 调用目标对象中得到方法
		// Method.invoke(obj,args)
		Object result = mproxy.invoke(proxy, args);
		System.out.println(method.getName() + "方法已经被调用");
		return result;
	}

}
