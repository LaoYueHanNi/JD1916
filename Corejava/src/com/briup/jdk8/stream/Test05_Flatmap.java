package com.briup.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * flatMap	一对多映射  
 * 	  stream中的每一个成员，映射 得到 多个值
 */
public class Test05_Flatmap {
	public static void main(String[] args) {
		//demo1();
		List<String> list = 
				Arrays.asList("hello:haode:world","nihao:buhao");
		
		/*list.stream()
			.flatMap(str->Stream.of(str.split(":")))
			.forEach(System.out::println);
		*/
		List<String> list2 = list.stream()
		.flatMap(str->Stream.of(str.split(":")))
		.collect(Collectors.toList());
		
		System.out.println(list2.size());
		//System.out.println(list2);
		list2.forEach(System.out::println);
	}

	private static void demo1() {
		List<String> list = 
				Arrays.asList("hello:haode:world","nihao:buhao");
		Stream<String> s1 = list.stream();
		
		//传入String 返回一个Stream
		Function<String, Stream<String>> f = 
				str->Stream.of(str.split(":"));
		
		//flatMap先由Stream里面的每一个字符串 获取到一个新的Stream
				//然后将所有的Stream合并成 一个Stream
		Stream<String> s2 = s1.flatMap(f);
		s2.forEach(System.out::println);
	}
}
