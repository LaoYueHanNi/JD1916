package com.briup.thread;

public class Printe extends Thread{
	Storage s;
	public Printe(Storage s) {
		this.s=s;
	}
	public void run() {
		synchronized (s) {
			for(int i=0;i<100;i++) {
				if(s.getFlag()!=2) {
					try {
						s.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("´òÓ¡:"+s.getA());
				
				s.setFlag(1);
				s.notify();
			}
		}
	}
}
