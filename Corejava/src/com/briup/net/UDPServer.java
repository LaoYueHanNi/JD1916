package com.briup.net;
import java.net.*;
import java.util.Date;
public class UDPServer {
	public static void main(String[] args) throws Exception {
		//1 创建DatagramSocket对象,并绑定端口
		DatagramSocket ds=new DatagramSocket(8888);
		//2创建DatagramPacket对象(数据包)
		//用于接收客户端发送的数据包
		byte[] buf=new byte[2048];
		DatagramPacket dp=new DatagramPacket(buf, buf.length);
		//3接受数据包
		ds.receive(dp);
		//输出数据包中的内容
		System.out.println("客户端说:"+new String(dp.getData()));
		//4发送数据包给客户端
			//4-1创建数据包
			//发送的数据
		buf=new Date().toString().getBytes();
			//发送数据包目的地的ip
		InetAddress address=dp.getAddress();
		int port=dp.getPort();
			//发送数据包目的地的port
		DatagramPacket dp1=new DatagramPacket(buf, buf.length,address,port);
			//4-2发送数据包
		ds.send(dp1);
		//5关闭资源
		if(ds!=null)ds.close();
	}
}
