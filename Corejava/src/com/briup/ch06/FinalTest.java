package com.briup.ch06;

public class FinalTest {
	private final int NUM;
	private final static int COUNT_1=2;
	private final static int COUNT_2;
	
	static {
		COUNT_2=5;
	}
	
	public  FinalTest() {
		NUM=10;
	}
	
	public void print() {
		final int a=7;
	}
}
