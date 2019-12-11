package com.briup.thread;

public class Test {
	public static void main(String[] args) {
		Storage s=new Storage();
		Counter c=new Counter(s);
		Printe p=new Printe(s);
		c.start();
		p.start();
	}
}
