package com.briup.Collection;

public class Test {
	public static void main(String[] args) {
		List list = //new ArrayList(2);
					new LinkedList();
		list.add(30);
		list.add("hello");
		list.add(false);
		list.add(1, "world");
		list.remove(2);
		list.set(0, 100);
		list.add(false);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	} 
}
