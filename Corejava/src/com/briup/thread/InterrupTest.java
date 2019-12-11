package com.briup.thread;

public class InterrupTest extends Thread{
	public void run() {
		System.out.println("sleep before..");
		try {
			sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("sleep interrup");
			e.printStackTrace();
		}
		System.out.println("end");
	}
	public static void main(String[] args) throws Exception {
		System.out.println("start");
		Thread t1=new InterrupTest();
		//Thread t2=new InterrupTest();
		t1.start();
		Thread.sleep(3000);
		//t2.start();                                                                                    
		System.out.println("end");
		
	}
}
