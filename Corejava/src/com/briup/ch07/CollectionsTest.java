package com.briup.ch07;
import java.util.*;
public class CollectionsTest {
	public static void main(String[] args) {
		List<Integer> list= new ArrayList<>();
		list.add(30);
		list.add(47);
		list.add(100);
		list.add(2);
		list.add(31);
		Collections.sort(list);//��Ȼ����
		//���ֲ���
		int index=Collections.binarySearch(list, 30);//���ֲ���
		System.out.println(index);
		Collections.shuffle(list);//ϴ���������
		System.out.println(list);
	}
}
