package com.briup.jdk8;
//���Ժ����ӿ�
@FunctionalInterface
interface Action{
	public void run();
	
	public default void doSomething() {
		System.out.println("do somethings");
	}
}
public class Test3_Function {
	public static void main(String[] args) {
		//�����ڲ���
		Action a1=new Action() {
			public void run() {
				System.out.println("run");
			}
		};
		a1.doSomething();
		a1.run();
		//Lambdab���ʽ
		Action a2=()->System.out.println("sd");
	}
}
