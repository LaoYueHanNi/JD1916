package com.briup.net;
import java.net.*;
import java.util.Date;
public class UDPServer {
	public static void main(String[] args) throws Exception {
		//1 ����DatagramSocket����,���󶨶˿�
		DatagramSocket ds=new DatagramSocket(8888);
		//2����DatagramPacket����(���ݰ�)
		//���ڽ��տͻ��˷��͵����ݰ�
		byte[] buf=new byte[2048];
		DatagramPacket dp=new DatagramPacket(buf, buf.length);
		//3�������ݰ�
		ds.receive(dp);
		//������ݰ��е�����
		System.out.println("�ͻ���˵:"+new String(dp.getData()));
		//4�������ݰ����ͻ���
			//4-1�������ݰ�
			//���͵�����
		buf=new Date().toString().getBytes();
			//�������ݰ�Ŀ�ĵص�ip
		InetAddress address=dp.getAddress();
		int port=dp.getPort();
			//�������ݰ�Ŀ�ĵص�port
		DatagramPacket dp1=new DatagramPacket(buf, buf.length,address,port);
			//4-2�������ݰ�
		ds.send(dp1);
		//5�ر���Դ
		if(ds!=null)ds.close();
	}
}
