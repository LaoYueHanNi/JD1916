package com.briup.jdk8.stream;

import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/*
 * ���ɵȲ�����
 * 	����һ�����ӣ������㷨 �õ��������Ϊ�ڶ������ӣ�Ȼ����ͬ�㷨
 * 	����õ����������ӣ���������
 */
public class Test15_iterate {
	public static void main(String[] args) {
		
		/*									����                         �㷨		
		 * static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
		 * 
		 * �㷨
		 * interface UnaryOperator<T> extends Function<T, T> {
		 * 	  T apply(T t);	
		 * 	//int apply(int n) { return n+2; } 
		 * }
		 * 
		 */
		
		//iterate����������reduce   
		//����һ���Ȳ�����
		Stream.iterate(0, n->n+2)
			.limit(10)
			.forEach(System.out::println);
		
	}
}
