package com.briup.jdk8;

import java.util.function.Consumer;

public class ConsumerTest {
	public static void main(String[] args) {
		Student s = new Student();
		s.setName("tom");
		
		Consumer<Student> first = stu->{
			System.out.println("我要第一个执行,把name值给改了");
			stu.setName("zhangsan");
		};
		
		Consumer<Student> second = t->{
			System.out.println("我第二个执行，输出name的值: " + t.getName());
		};
		
		//两个紧挨着执行
		Consumer<Student> c = first.andThen(second);
		c.accept(s);
	}
}
