package com.briup.jdk8.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * collect �ռ����������һ�����ϡ�
 * 
 */
public class Test16_collect {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("hello","abc","world","nihao","max","min");
		
		/* ��Stream�����collect����ԭ��Ϊ:
		 * <R, A> R collect(Collector<? super T, A, R> collector);
		 * 
		 * ��Collectors�еľ�̬����toListԭ��:
		 * public static <T>
    			Collector<T, ?, List<T>> toList() { ... }
		 * ���صĶ��� ���� ���Էŵ�collect������!!!
		 */
		List<String> list2 = list.stream()
			.filter(s->s.length()>3)
			.collect(Collectors.toList());
		
		System.out.println(list2);
		
	}
}
