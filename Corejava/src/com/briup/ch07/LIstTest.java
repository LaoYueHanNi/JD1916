package com.briup.ch07;
//����List��
import java.util.*;

public class LIstTest {
	public static void main(String[] args) {
		//��������
		List list =new ArrayList();
		//��������
		list.add(20);
		list.add(0,false);
		list.add("hello");
		list.add(1,"world");
		list.remove(0);
		list.set(0,"jd1916");
		
		out1(list);
		out2(list);
		out3(list);
	}
	public static void out1(List list) {
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
	}
	public static void out2(List list) {
		for(Object temp:list) {
			System.out.print(temp+" ");
		}
		System.out.println();
	}
	public static void out3(List list) {
		//ʹ�õ���������
		Iterator iter=list.iterator();
		while(iter.hasNext()) {
			Object obj=iter.next();
			System.out.print(obj+" ");
		}
	}
}
