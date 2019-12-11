package com.briup.jdk8;

import java.util.function.Function;

public class FunctionTest {
	public static void main(String[] args) {
		/*�û�ע������һ������tom*/
		String name = "tom";
		
		/*ʹ���û�����������ִ���һ������*/
		Function<String, Student> f1 =(s)->new Student(s);
		//ע������Ĵ���Ҳ����д������,�������еĹ�����
		//Function<String, Student> f1 = Student::new;
		Student stu1 = f1.apply(name);
		System.out.println(stu1.getName());
		
		System.out.println("------------------------");
		/*����ı�,ʹ��name����Student����֮ǰ��Ҫ��name��һ��ǰ׺*/
		Function<String,String> before = (s)->"briup_"+s;
		//��ʾf1����֮ǰ��ִ��before����ķ���,��before����ķ������ؽ����Ϊf1���󷽷��Ĳ���
		Student stu2 = f1.compose(before).apply(name);
		//����һ�п��Բ�ֳ���������
		//String v = before.apply(name);
		//Student stu2 = f1.apply(v);
		
		System.out.println(stu2.getName());
		System.out.println("--------------------------------");
		/*��ô����õĶ����е����ֵĳ���*/
		Function<Student,Integer> after = (stu)->stu.getName().length();
		//before�ȵ��÷���,�����Ϊ��������f1�����÷���,�������Ϊ��������after,����������ǽ��յ�����
		int len = f1.compose(before).andThen(after).apply(name);
		System.out.println(len);
		
		//��ֺ�Ϊ
		//String v = before.apply(name);
		//Student stu = f1.apply(v);
		//int len = after.apply(stu);
		
		Function<String,String> f2 = Function.identity();
		System.out.println(f2.apply(name));
	}
}
