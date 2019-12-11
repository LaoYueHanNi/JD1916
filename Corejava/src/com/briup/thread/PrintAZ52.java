package com.briup.thread;


class Print{
	private int index=1;
	public synchronized void print(int i) throws InterruptedException{
		while(index%3==0) {
			wait();
		}
		System.out.print(i);
		index++;
		notifyAll();
	}
	
	public synchronized void print(char c) throws InterruptedException{
		while(index%3!=0) {
			wait();
		}
		System.out.print(c);
		index++;
		notifyAll();
	}
}

class NumberPrint implements Runnable{
	private Print p;
	
	public NumberPrint(Print p) {
		this.p=p;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<53;i++) {
			try {
				p.print(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class LetterPrint implements Runnable{
	private Print p;
	
	public LetterPrint(Print p) {
		this.p=p;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<27;i++) {
			try {
				p.print((char)(i+96));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
public class PrintAZ52 {
	public static void main(String[] args) {
		Print p=new Print();
		Thread t1=new Thread(new NumberPrint(p));
		Thread t2=new Thread(new LetterPrint(p));
		t1.start();
		t2.start();
	}
}
