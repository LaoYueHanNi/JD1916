package com.briup.jdk8.stream;

import java.util.PrimitiveIterator.OfInt;
import java.util.stream.IntStream;

/*
 * IntStream == Stream<T> + ���⺯��
 */
public class Test02_IntStream {
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4};
		IntStream s1 = IntStream.of(arr);
		System.out.println(s1.count());
		System.out.println("------------------");
		//[1,3)
		IntStream s2 = IntStream.range(1, 3);//ȡ1��3����ҿ�
		OfInt oi1 = s2.iterator();
		while(oi1.hasNext()) {
			System.out.println(oi1.next());
		}
		System.out.println("------------------");
		//[1,3]
		IntStream s3 = IntStream.rangeClosed(1, 3);
		//ע�⣺ stream�������֣�ֻ��ʹ��һ��
		System.out.println(s3.max());
	}
}
