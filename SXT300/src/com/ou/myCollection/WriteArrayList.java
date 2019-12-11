package com.ou.myCollection;
// ÷–¥ArrayList
public class WriteArrayList {
	private Object[] elementData;
	private int size;
	
	public WriteArrayList() {
		 this(10);
	}
	
	public WriteArrayList(int length) {
		elementData=new Object[length];
	}
	
	public void add(Object obj) {
		elementData[size++]=obj;
	}
	
	public static void main(String[] args) {
		WriteArrayList a1=new WriteArrayList(20); 
		a1.add("aa");
		a1.add("bb");
		System.out.println(a1);
	}	
}
 