package com.briup.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Stream<T> 接口
 * stream对象的 获取
 */
public class Test01_StreamCreate {
	public static void main(String[] args) {
		//1.使用Stream中of函数
		Stream<String> s1 = Stream.of("hello","world","nihao");
		System.out.println(s1);
		
		String[] arr = {"hello","world","nihao"};
		Stream<String> s2 = Stream.of(arr);
		
		System.out.println("*************");
		
		//2.借助Arrays中stream方法 构建
		Stream<String> s3 = Arrays.stream(arr);
		
		//3.利用集合中stream方法 构建【不支持map集合】
		List<String> list = Arrays.asList("hello","world","nihao");
		Stream<String> s4 = list.stream();
	}
}