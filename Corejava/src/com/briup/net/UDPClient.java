package com.briup.net;
import java.net.*;
public class UDPClient {
	public static void main(String[] args) throws Exception{
		//1创建DatagramSocket对象
		DatagramSocket ds=new DatagramSocket();
		//2创建数据包的对象,用于发送
		byte[] buf =new byte[2048];
		buf="please give me your time".getBytes();
		InetAddress address=InetAddress.getByName("127.0.0.1");
		int port=8888;
		DatagramPacket dp=new DatagramPacket(buf, buf.length,address,port);
		//3发送数据包
		ds.send(dp);
		//4接受数据包
			//4-创建数据包
		DatagramPacket dp1=new DatagramPacket(buf, buf.length);
			//4-2j接受数据包
		ds.receive(dp1);
		System.out.println("来自服务器端的:"+new String(dp1.getData()));
		//5关闭资源
		if(ds!=null)ds.close();
	}
}
