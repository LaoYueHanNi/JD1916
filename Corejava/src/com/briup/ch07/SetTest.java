package com.briup.ch07;

import java.util.*;
public class SetTest {
	//����Set�ӿڵĹ���
	public static void main(String[] args) {
		Set set=new HashSet();
		set.add("a");
		set.add(1);
		set.add("a");
		set.add("c");
		System.out.println("size="+set.size());
		for(Object temp:set) {
			System.out.print(temp+" ");
		}
	}
}
