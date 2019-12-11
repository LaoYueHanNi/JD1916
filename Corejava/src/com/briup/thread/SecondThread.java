package com.briup.thread;

public class SecondThread implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<=20;i++) {
			//currentThread()获取当前线程对象
			System.out.println(Thread.currentThread().getName()+":"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		//创建进程对象
		Runnable runnable=new SecondThread();
		Thread t1=new Thread(runnable);
		Thread t2=new Thread(runnable);
		//开始
		t1.start();
		t2.start();
	}
		
	
}
