package com.briup.net;
import java.net.*;
public class UDPClient {
	public static void main(String[] args) throws Exception{
		//1����DatagramSocket����
		DatagramSocket ds=new DatagramSocket();
		//2�������ݰ��Ķ���,���ڷ���
		byte[] buf =new byte[2048];
		buf="please give me your time".getBytes();
		InetAddress address=InetAddress.getByName("127.0.0.1");
		int port=8888;
		DatagramPacket dp=new DatagramPacket(buf, buf.length,address,port);
		//3�������ݰ�
		ds.send(dp);
		//4�������ݰ�
			//4-�������ݰ�
		DatagramPacket dp1=new DatagramPacket(buf, buf.length);
			//4-2j�������ݰ�
		ds.receive(dp1);
		System.out.println("���Է������˵�:"+new String(dp1.getData()));
		//5�ر���Դ
		if(ds!=null)ds.close();
	}
}
