package com.briup.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/*
 * sorted
 * sorted(�Ƚ���)
 */
public class Test09_Sort {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("test","hello","world","java","tom","C","javascript");
		
		//1.�޲�sorted() Ĭ������ �ֵ�����
		list.stream().filter(s->s.startsWith("j"))//���˳���
		             .sorted()
		             .forEach(System.out::println);
		System.out.println("***********");
		
		//2.�в�sorted(Comparator<? super T> comparator) 
		//�����ַ����ĳ�������
		list.stream()
		    .sorted((s1,s2)->s1.length()-s2.length())
		    .forEach(System.out::println);
		
		List<Integer> list2 = Arrays.asList(1,2,3,4,5,6,7,8,9);
		list2.stream().sorted((o1,o2)->{
			//���������� ż��
			if(o1%2 == 0 && o2%2 == 0) {
				return o1-o2; //˳��
			}else if(o1%2 != 0 && o2%2 != 0) { //��������
				return o2-o1; //����
			}else if(o1%2 == 0 && o2%2 != 0) {	//��һ��ż�� �ڶ�������
				return 1;	//ż������  ���ں���
			}else {	//��һ������ �ڶ���ż��
				return -1;	//����С  ����ǰ��
			}
		}).forEach(System.out::println);

	}
}







