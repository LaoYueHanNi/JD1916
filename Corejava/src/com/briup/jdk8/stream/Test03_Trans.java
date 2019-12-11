package com.briup.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Stream对象 转换成  其他类型[数组，集合]
 * 	转化成数组  stream.toArray();
 * 	转换成一般集合: stream.collect(Colletors.toList());
 *  转换成特定集合: stream.collect(Colletors.toCollect(ArrayList::new)); 
 */
public class Test03_Trans {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("hello","world","tom");
		
		//
		// 1. 转换为Array           toArray(i->new String[i])
		Object[] array = stream.toArray();
		
		for (Object string : array) {
			System.out.println(string);
		}
		
		System.out.println("**************");
		
		//注意： stream单独出现，只能使用一次
		Stream<String> stream2 = Stream.of("hello","world","tom");
		
		String[] arr = 
				stream2.toArray(String[]::new);
				//stream2.toArray(n->new String[n]);
		for (String string : arr) {
			System.out.println(string);
		}
		
		System.out.println("***********");
		
		//2.stream转换成 list集合【固定用法】
		Stream<String> stream3 = Stream.of("hello","world","nihao","hello");
//		List<String> list = 
//				stream3.collect(Collectors.toList());
		
		//指定 转换的 具体集合类型
		List<String> list2 = 
				stream3.collect(Collectors.toCollection(ArrayList::new));
		System.out.println("list2: " + list2);
		/*
		Set<String> set = 
				stream3.collect(Collectors.toSet());
		*/
//		HashSet<String> set2 = 
//				stream3.collect(Collectors.toCollection(HashSet::new));
//		System.out.println(set2);
		
		//3.转化为String
		Stream<String> stream4 = Stream.of("hello","world","nihao","hello");
		String str = stream4.collect(Collectors.joining()).toString();
		System.out.println(str);
	}
	
}
