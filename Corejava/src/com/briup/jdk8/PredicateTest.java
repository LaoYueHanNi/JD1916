package com.briup.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {
	public static void filter(List<String> list, Predicate<String> condition) {  
		for(String name: list) {  
			if(condition.test(name)) {  
				System.out.println(name);  
			}  
		}  
	}  
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Java", "html5","JavaScript", "C++", "hibernate", "PHP");
		//ȫ����ʾ
		filter(list, name->true);
		System.out.println("--------------------");
		//ȫ������ʾ
		filter(list, name->false);
		System.out.println("--------------------");
		//��ͷ��J������
		filter(list,name->name.startsWith("J"));
		System.out.println("--------------------");
		//5��β��
		filter(list,name->name.endsWith("5"));
		System.out.println("--------------------");
		//��ʾ���ֳ��ȴ���4
		filter(list,name->name.length()>4);
		System.out.println("--------------------");

		//������J��ͷ���ҳ��ȴ���4��
		Predicate<String> c1 = name->name.startsWith("J");
		Predicate<String> c2 = name->name.length()>4;
		filter(list,c1.and(c2));
		System.out.println("--------------------");
		
		//���ֲ�����J��ͷ
		Predicate<String> c3 = (name)->name.startsWith("J");
		filter(list,c3.negate());
		System.out.println("--------------------");
		
		//������J��ͷ���߳���С��4��
		Predicate<String> c4 = name->name.startsWith("J");
		Predicate<String> c5 = name->name.length()<4;
		filter(list,c4.or(c5));
		System.out.println("--------------------");
		//Ҳ����ֱ��ʹ��Predicate�ӿ��еľ�̬����
		//����ΪJava��
		filter(list,Predicate.isEqual("Java"));
		System.out.println("--------------------");
		//�ж������ַ����Ƿ����
		boolean test = Predicate.isEqual("hello").test("world");
		System.out.println(test);
	}
}
