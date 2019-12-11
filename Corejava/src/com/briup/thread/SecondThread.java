package com.briup.thread;

public class SecondThread implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<=20;i++) {
			//currentThread()��ȡ��ǰ�̶߳���
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
		//�������̶���
		Runnable runnable=new SecondThread();
		Thread t1=new Thread(runnable);
		Thread t2=new Thread(runnable);
		//��ʼ
		t1.start();
		t2.start();
	}
		
	
}
