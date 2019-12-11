package com.briup.thread;

public class RaceTest extends Thread{
	//�����Ƿ�����ı�ʶ����
	private static boolean isEnd=false;
	public RaceTest(String name) {
		super(name);
	}
	public void run() {
		int sum=0;

		while(sum<100) {
			if(isEnd)return;
			//ÿһ�������1��10��
			int index=(int)(Math.random()*10+1);
			sum+=index;
			System.out.println(getName()+"����"+sum+"��");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		isEnd=true;
	}
	public static void main(String[] args) throws Exception {
		System.out.println("������ʼ....");
		Thread rabbit=new RaceTest("����");
		Thread turtoise=new RaceTest("�ڹ�");
		rabbit.start();
		turtoise.start();
		rabbit.join();
		turtoise.join();
		System.out.println("end");
	}
}
