package com.briup.thread;

public class Counter extends Thread{
	Storage s;
	public Counter(Storage s) {
		this.s=s;
	}
	public void run() {
		synchronized (s) {
			for(int i=0;i<100;i++) {
				if(s.getFlag()!=1) {
					try {
						s.wait();
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				s.setA(i);
				System.out.println("¸³Öµ"+i);
				s.setFlag(0);
				s.notify();
			}
		}
	}
}
