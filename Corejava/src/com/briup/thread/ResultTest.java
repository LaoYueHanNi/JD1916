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
		//������Ʒ
		result.setValue(sum);
		//�ж��Ƿ��еȴ��õ��߳�
		if(!result.isIswait()) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//֪ͨ������
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
		//�������ߵ��̵߳ȴ�
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
		System.out.println("������:"+value);
	}
}
public class ResultTest {
	public static void main(String[] args) {
		Result result=new Result();
		Sender s=new Sender("������",result);
		Printer p=new Printer("������",result);
		p.start();
		s.start();
	}
}
