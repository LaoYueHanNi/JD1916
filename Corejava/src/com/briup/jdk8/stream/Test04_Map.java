package com.briup.jdk8.stream;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * map	һ��һӳ�� ��  stream�е�ÿһ����Ա ӳ��õ� ����һ��ֵ
 * flatMap	һ�Զ�ӳ��  stream�е�ÿһ����Ա��ӳ�� �õ� ���ֵ
 */
public class Test04_Map {
	public static void main(String[] args) {
		//demo1();
		System.out.println("----------------------");

		Stream<String> s = Stream.of("hello","nihao","abc","everyone");
		//��ˮ��д��   ��ʽ���
		s.map(str->str.length())
		 //.collect(Collectors.toList())
		 .forEach(System.out::println);
	}

	//��ͨʵ�ַ�ʽ
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
