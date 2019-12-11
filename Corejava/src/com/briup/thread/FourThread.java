package com.briup.thread;  

public class FourThread {
	private static int count;
	static int i;
	private static Object lock =new Object();
	
	static class TheThread implements Runnable{
		int id;
		public TheThread(int id) {
			this.id=id;
		}
		@Override
		public void run() {
			for(;;) {
				synchronized (lock) {
					while(id!=count%4) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(id==0||id==1) {
						System.out.println(i++);
					}
					if(id==2||id==3) {
						System.out.println(i--);
					}
					count++;
					lock.notifyAll();
				}
			}
		}
	}
	public static void main(String[] args) {
		Thread a=new Thread(new TheThread(0));
		Thread b=new Thread(new TheThread(1));
		Thread c=new Thread(new TheThread(2));
		Thread d=new Thread(new TheThread(3));
		a.start();
		b.start();
		c.start();
		d.start();
	}
}
