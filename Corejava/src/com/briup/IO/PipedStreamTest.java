package com.briup.IO;

import java.io.*;

class Sender extends Thread{
	private PipedOutputStream pos;
	public Sender(PipedOutputStream pos) {
		this.pos=pos;
	}
	public void run() {
		DataOutputStream dos=null;
		try {
			dos=new DataOutputStream(pos);
			for(int i=1;i<=20;i++) {
				dos.writeInt(i);
				dos.flush();
				sleep(1000);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
class Printer extends Thread{
	private PipedInputStream pis;
	public Printer(PipedInputStream pis) {
		this.pis=pis;
	}
	public void run() {
		DataInputStream dis=null;
		try {
			dis=new DataInputStream(pis);
			for(int i=1;i<=20;i++) {
				int result=dis.readInt();
				System.out.println("该线程:"+result);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
public class PipedStreamTest{
	public static void main(String[] args) throws IOException {
		//写数据的线程
		PipedOutputStream pos=new PipedOutputStream();
		Sender s=new Sender(pos);
		//读数据的线程
		PipedInputStream pis=new PipedInputStream();
		Printer p=new Printer(pis);
		//管道输入流和管道输出流连接
		pos.connect(pis);
		s.start();
		p.start();
	}
	
}
