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
				System.out.println("���߳�:"+result);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
public class PipedStreamTest{
	public static void main(String[] args) throws IOException {
		//д���ݵ��߳�
		PipedOutputStream pos=new PipedOutputStream();
		Sender s=new Sender(pos);
		//�����ݵ��߳�
		PipedInputStream pis=new PipedInputStream();
		Printer p=new Printer(pis);
		//�ܵ��������͹ܵ����������
		pos.connect(pis);
		s.start();
		p.start();
	}
	
}
