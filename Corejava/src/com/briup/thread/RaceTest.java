package com.briup.thread;

public class RaceTest extends Thread{
	//比赛是否结束的标识变量
	private static boolean isEnd=false;
	public RaceTest(String name) {
		super(name);
	}
	public void run() {
		int sum=0;

		while(sum<100) {
			if(isEnd)return;
			//每一步随机跑1到10米
			int index=(int)(Math.random()*10+1);
			sum+=index;
			System.out.println(getName()+"跑了"+sum+"米");
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
		System.out.println("比赛开始....");
		Thread rabbit=new RaceTest("兔子");
		Thread turtoise=new RaceTest("乌龟");
		rabbit.start();
		turtoise.start();
		rabbit.join();
		turtoise.join();
		System.out.println("end");
	}
}
