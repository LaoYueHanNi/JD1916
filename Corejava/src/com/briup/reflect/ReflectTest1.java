package com.briup.reflect;

//测试反射:通过镜像对象来获取class类中所有属性,所有方法,所有的构造器的信息
import java.lang.reflect.*;

public class ReflectTest1 {
	public static void main(String[] args) throws Exception {
		// 1,获取大写Class对象
		Class clz = Class.forName("com.briup.reflect.Dog");
		System.out.println(clz);
		// 获取Dog类中所有的属性
		Field[] fs = clz.getDeclaredFields();
		for (Field temp : fs) {
			// 属性的修饰符
			int mofiy = temp.getModifiers();
			// 属性的名字
			String name = temp.getName();
			// 属性的数据类型
			Class c = temp.getType();
			System.out.println(mofiy + " " + name + " " + c);
		}
		// 获取Dog的所有方法
		Method[] method = clz.getDeclaredMethods();
		for (Method temp : method) {
			// 方法名
			String name=temp.getName();
			// 修饰符
			int mofiy=temp.getModifiers();
			// 方法返回值类型
			Class[] p=temp.getParameterTypes();
			// 参数列表
			Class r=temp.getReturnType();
			System.out.print(mofiy+" "+r+" "+name+"(");
			String sp="";
			for(Class pp:p) {
				System.out.print(sp);
				System.out.print(pp);
				sp=",";
			}
			System.out.print(")");
			System.out.println();
		}
		//获取参数列表
		Constructor[] cons=clz.getDeclaredConstructors();
		for(Constructor con:cons) {
			//构造器的参数列表
			//构造器的修饰符
		}
	}
}
