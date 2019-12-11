package com.briup.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * findFirst ��ȡ��һ��Ԫ��ֵ
 */
public class Test08_findFirst {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("test","hello","world");
		Optional<String> first = list.stream().findFirst();
		System.out.println(first);
		System.out.println(first.orElse("ֵΪnull"));
	}
}
