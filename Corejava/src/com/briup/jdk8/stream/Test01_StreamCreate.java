package com.briup.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Stream<T> �ӿ�
 * stream����� ��ȡ
 */
public class Test01_StreamCreate {
	public static void main(String[] args) {
		//1.ʹ��Stream��of����
		Stream<String> s1 = Stream.of("hello","world","nihao");
		System.out.println(s1);
		
		String[] arr = {"hello","world","nihao"};
		Stream<String> s2 = Stream.of(arr);
		
		System.out.println("*************");
		
		//2.����Arrays��stream���� ����
		Stream<String> s3 = Arrays.stream(arr);
		
		//3.���ü�����stream���� ��������֧��map���ϡ�
		List<String> list = Arrays.asList("hello","world","nihao");
		Stream<String> s4 = list.stream();
	}
}