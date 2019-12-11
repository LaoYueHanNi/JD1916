package com.briup.reflect;
//测试反射:通过调用一个对象的属性
	//调用一个对象的方法
	//创建一个类的对象(不使用new)
import java.lang.reflect.*;

public class ReflectTest2 {
	public static void main(String[] args)throws Exception {
		//1获取镜像对象
		Class clz =Class.forName("com.briup.reflect.Dog");
		//2创建镜像对象创建Dog类的对象,不使用new关键字创建
		 Dog dog=(Dog) clz.newInstance();//创建的是一个Class的对象
		//3操作属性  对象.name="briup"
			//获取某一个属性对象
		Field f=clz.getDeclaredField("name");
		f.setAccessible(true);//设置权限
			//设置属性的值
		System.out.println(f.get(dog));
		f.set(dog, "jack");
			//获取属性的值
		System.out.println(f.get(dog));
		
		//4操作方法
		 	//获取方法
		Method method=clz.getMethod("print", int.class,int.class);
			//调用方法
		Object result=method.invoke(dog, 3,5);
		System.out.println("result:"+result);
		
	}
}
