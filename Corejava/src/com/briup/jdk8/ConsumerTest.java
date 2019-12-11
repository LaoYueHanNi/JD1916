package com.briup.jdk8;

import java.util.function.Consumer;

public class ConsumerTest {
	public static void main(String[] args) {
		Student s = new Student();
		s.setName("tom");
		
		Consumer<Student> first = stu->{
			System.out.println("��Ҫ��һ��ִ��,��nameֵ������");
			stu.setName("zhangsan");
		};
		
		Consumer<Student> second = t->{
			System.out.println("�ҵڶ���ִ�У����name��ֵ: " + t.getName());
		};
		
		//����������ִ��
		Consumer<Student> c = first.andThen(second);
		c.accept(s);
	}
}