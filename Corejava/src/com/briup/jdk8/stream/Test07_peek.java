package com.briup.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * peek ��ÿ��Ԫ��ִ�в���
 * 	Stream peek(Consumer c);
 */
public class Test07_peek {
	public static void main(String[] args) {
		
		//ע�� peek����һ��Ҫ��  ���ղ���������peek��ִ��
		List<String> list = Arrays.asList("one", "two", "three", "four");
		List<String> list2 = list.stream()
						 .filter(e -> e.length() > 3)//����Ԫ�� 
						 .peek(e->System.out.println("����������ֵΪ: " + e))
						 .collect(Collectors.toList());
		//��ӡ���Ϊ 2
		System.out.println(list2.size());
	}
}
