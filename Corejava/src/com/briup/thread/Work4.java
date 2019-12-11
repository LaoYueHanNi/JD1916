package com.briup.thread;

public class Work4 implements Runnable{
	
	int[] arr= {10,5,20,50,100,200,500,800,2,80,300};
	public void run() {
		System.out.println(Thread.currentThread().getName()+" "+arr[(int)(Math.random()*11)]);
	}
	public static void main(String[] args) {
		Runnable r=new Work4();
		Thread t1=new Thread(r,"≥ÈΩ±œ‰1");
		Thread t2=new Thread(r,"≥ÈΩ±œ‰2"); 
		t1.start();
		t2.start();
	}
}
