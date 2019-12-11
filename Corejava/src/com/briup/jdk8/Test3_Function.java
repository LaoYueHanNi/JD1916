package com.briup.jdk8;
//测试函数接口
@FunctionalInterface
interface Action{
	public void run();
	
	public default void doSomething() {
		System.out.println("do somethings");
	}
}
public class Test3_Function {
	public static void main(String[] args) {
		//匿名内部类
		Action a1=new Action() {
			public void run() {
				System.out.println("run");
			}
		};
		a1.doSomething();
		a1.run();
		//Lambdab表达式
		Action a2=()->System.out.println("sd");
	}
}
