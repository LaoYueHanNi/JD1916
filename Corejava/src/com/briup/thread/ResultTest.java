package com.briup.thread;

class Sender extends Thread{
	private Result result;
	public Sender(String name,Result result) {
		super(name);
		this.result=result;
	}
	public void run() {
		int sum=0;
		for(int i=1;i<=100;i++) {
			sum+=i;
		}
		//生产产品
		result.setValue(sum);
		//判断是否有等待得到线程
		if(!result.isIswait()) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//通知消费者
		synchronized (result) {
			result.notify();
		}
	}
	
}
class Printer extends Thread{
	private Result result;
	public Printer(String name,Result result) {
		super(name);
		this.result=result;
	}
	public void run() {
		//让消费者的线程等待
		synchronized (result) {
			try {
				result.setIswait(true);
				result.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated c atch block
				e.printStackTrace();
			}
		}
		int value=result.getValue();
		System.out.println("消费者:"+value);
	}
}
public class ResultTest {
	public static void main(String[] args) {
		Result result=new Result();
		Sender s=new Sender("生产者",result);
		Printer p=new Printer("消费者",result);
		p.start();
		s.start();
	}
}
