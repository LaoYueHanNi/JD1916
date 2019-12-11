package com.briup.jdk8;

import java.util.function.BinaryOperator;

public class BinaryOperatorTest {
	public static void main(String[] args) {
		//���������ַ�����������Сд��ϲ�
		BinaryOperator<String> bo = (s1,s2)->s1.toUpperCase()+s2.toLowerCase();
		String str = bo.apply("hello", "world");
		System.out.println(str);
		
		//��������int������ȡ��С��ֵ
		BinaryOperator<Integer> bo2 = BinaryOperator.minBy((a1,a2)->a1-a2);
		int x = 1;
		int y = 3;
		Integer num = bo2.apply(x,y);
		System.out.println(num);
	}
}
