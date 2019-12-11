package com.briup.net;
import java.net.*;
import java.io.*;
//服务器端
public class TCPServer {
	public static void main(String[] args) {
		ServerSocket ss=null;
		Socket socket=null;
		BufferedReader br=null;
		PrintWriter pw=null;
		try {
			//1创建serverSocket对象,并绑定端口号
			ss=new ServerSocket(9999);
			System.out.println("服务器端已经在9999端口启动...");
			while(true) {
				//2.等待客户端连接accept(),有阻塞功能
				socket=ss.accept();
				//3.先读取客户端发送过来的数据
				InputStream is=socket.getInputStream();
				br=new BufferedReader(new InputStreamReader(is));
				String msg=br.readLine();
				System.out.println("客户端说:"+msg);
				//4发送数据给客户端
				pw=new PrintWriter(socket.getOutputStream());
				pw.println(new java.util.Date());
				pw.flush();
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//5关闭资源(先开的后关)
				try {
					if(pw!=null)pw.close();
					if(br!=null)br.close();
					if(socket!=null)socket.close();
					if(ss!=null)ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}
}
