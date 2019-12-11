package com.briup.jdk8.stream;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * map	一对一映射 ：  stream中的每一个成员 映射得到 另外一个值
 * flatMap	一对多映射  stream中的每一个成员，映射 得到 多个值
 */
public class Test04_Map {
	public static void main(String[] args) {
		//demo1();
		System.out.println("----------------------");

		Stream<String> s = Stream.of("hello","nihao","abc","everyone");
		//流水线写法   链式编程
		s.map(str->str.length())
		 //.collect(Collectors.toList())
		 .forEach(System.out::println);
	}

	//普通实现方式
	private static void demo1() {
		Stream<String> s = Stream.of("hello","nihao","abc","everyone");
		
		Function<String, Integer> f = t->t.length();
		Stream<Integer> s2 = s.map(f);
		
		Consumer<Integer> c = 
				System.out::println;
//				num->System.out.println(num);
		s2.forEach(c);
	}
}
