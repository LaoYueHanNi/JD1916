package com.briup.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * findFirst 获取第一个元素值
 */
public class Test08_findFirst {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("test","hello","world");
		Optional<String> first = list.stream().findFirst();
		System.out.println(first);
		System.out.println(first.orElse("值为null"));
	}
}
