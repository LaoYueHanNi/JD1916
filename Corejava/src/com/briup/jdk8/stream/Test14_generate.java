package com.briup.jdk8.stream;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/*
 * generate ���ɺ�����������
 */
public class Test14_generate {
	public static void main(String[] args) {
		/*
		 * public static<T> Stream<T> generate(Supplier<T> s);
		 * 	
		 * public interface Supplier<T> {  //��Ӧ��
		 * 	  T get();
		 * }
		 */
		
		//����5�� [0,30) �������Ȼ�����
		Stream.generate(()->new Random().nextInt(30))
			.limit(5)
			.forEach(System.out::println);
		
	}
}
