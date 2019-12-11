package com.briup.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
 * ����stream����
 */
public class Test18_parallelStream {
	public static void main(String[] args) {
		
		//����100�����ͬ���ַ����ŵ�������
		int max = 1000000;
		List<String> list = new ArrayList<String>(max);
		for (int i = 0; i < max; i++) {
			//���� ���������
		    UUID uuid = UUID.randomUUID();
		    list.add(uuid.toString());
		}


		//1����*10^9=1�� 
		long t0 = System.nanoTime();
		//����stream 
		//long count = list.stream().sorted().count();
		//����stream
		long count = list.parallelStream().sorted().count();
		long t1 = System.nanoTime();

		long time = t1 - t0;
		System.out.println(count);
		System.out.println(time);
	}
	
}
