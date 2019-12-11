package com.briup.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Stream���� ת����  ��������[���飬����]
 * 	ת��������  stream.toArray();
 * 	ת����һ�㼯��: stream.collect(Colletors.toList());
 *  ת�����ض�����: stream.collect(Colletors.toCollect(ArrayList::new)); 
 */
public class Test03_Trans {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("hello","world","tom");
		
		//
		// 1. ת��ΪArray           toArray(i->new String[i])
		Object[] array = stream.toArray();
		
		for (Object string : array) {
			System.out.println(string);
		}
		
		System.out.println("**************");
		
		//ע�⣺ stream�������֣�ֻ��ʹ��һ��
		Stream<String> stream2 = Stream.of("hello","world","tom");
		
		String[] arr = 
				stream2.toArray(String[]::new);
				//stream2.toArray(n->new String[n]);
		for (String string : arr) {
			System.out.println(string);
		}
		
		System.out.println("***********");
		
		//2.streamת���� list���ϡ��̶��÷���
		Stream<String> stream3 = Stream.of("hello","world","nihao","hello");
//		List<String> list = 
//				stream3.collect(Collectors.toList());
		
		//ָ�� ת���� ���弯������
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
		
		//3.ת��ΪString
		Stream<String> stream4 = Stream.of("hello","world","nihao","hello");
		String str = stream4.collect(Collectors.joining()).toString();
		System.out.println(str);
	}
	
}
