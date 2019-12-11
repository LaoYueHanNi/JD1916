package com.briup.net;
import java.io.*;
import java.net.*;
public class TCPClient {
	public static void main(String[] args) {
		Socket socket=null;
		BufferedReader br=null;
		PrintWriter pw=null;
		try {
			//创建socket对象,连接服务器端
			socket =new Socket("192.168.43.252",9999);
			//发送数据给服务器端
			pw=new PrintWriter(socket.getOutputStream());
			pw.println("please give me your time");
			pw.flush();
			//接受服务器端的数据
			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg=br.readLine();
			System.out.println("来自服务器的时间"+msg);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pw!=null)pw.close();
				if(br!=null)br.close();
				if(socket!=null)socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
