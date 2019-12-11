package com.briup.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test12_reduce {
	public static void main(String[] args) {
		IntStream stream = IntStream.rangeClosed(1, 10);
		 //��1~10֮��������ۼ�
		//1.�õ�����0  �͵�һ��Ԫ�ز���������ٺ͵ڶ�����...���� �ó����
		Integer sum1 = stream.reduce(0, (a,b)->a+b); 
		//��
		//Integer sum2 = stream.reduce(0, Integer::sum);
		
		System.out.println(sum1);
		
		//2.����Сֵ
		IntStream stream2 = IntStream.rangeClosed(1, 10);
		OptionalInt min = stream2.reduce((a,b)->a<b?a:b);
		System.out.println(min);

		//3.ƴ�ӷ����ַ���
		String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat); 
		System.out.println(concat);
		
		//Optional<T> reduce(BinaryOperator<T> accumulator);
		//4.ƴ�ӷ��� Optional
		Optional<String> opStr = Stream.of("A", "B", "C", "D").reduce(String::concat);
		System.out.println(opStr);
		
		//�ۺϲ���
		List<String> list = Arrays.asList("test","javap","hello","world","java","tom","C","javascript");
		//
		Optional<String> reduce = list.stream()
				.sorted((s1,s2)->s2.length()-s1.length())	//�Ȱ��ճ��� ����
				.filter(s->s.startsWith("j"))				//ɸѡj��ͷ��
				.map(s->s+"_briup")							//������_briup��׺
				.reduce((s1,s2)->s1+"|"+s2);				
		System.out.println(reduce);
	}
}
