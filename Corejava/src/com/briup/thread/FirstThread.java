package com.briup.thread;

public class FirstThread extends Thread {
	public void run() {
		for(int i=0;i<=20;i++) {
			//getName()��ȡ��ǰ�̵߳�����
			System.out.println(getName()+":"+i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		//�����̶߳���
		System.out.println("START");
		Thread t1=new FirstThread();
		Thread t2=new FirstThread();
		//�����߳�
		t1.start();
		t2.start();
		System.out.println("END");
	}
}
