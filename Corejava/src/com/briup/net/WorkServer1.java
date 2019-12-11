package com.briup.net;

import java.net.ServerSocket;

//1.网络编程(TCP协议)
//客户端向服务器上传文件
//客户端
//1.提示输入要上传的文件路径File，验证路径是否存在以及是否是文件夹
//2.发送文件名到服务器
//6.接收结果，如果存在给予提示，否则程序直接退出
//7.如果不存在，定义FileInputStream读取文件，通过网络上传
//
//服务器
//3.建立多线程服务器
//4.读取文件名
//5.判断文件名是否存在，将结果返回给客户端
//8.接收文件 
import java.io.*;
import java.net.*;
public class WorkServer1 {
	public static void main(String[] args) {	
		ServerSocket ss=null;
		Socket socket=null;
		try {
			ss=new ServerSocket(7657);
			System.out.println("服务器端7657已启动");
			while(true) {
				socket=ss.accept();
				new Sthread(socket).start();;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

class Sthread extends Thread{
	private Socket socket;
	public Sthread(Socket socket) {
		this.socket=socket;
	}
	public void run() {
		try {
			InputStream is=socket.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream ps=new PrintStream(socket.getOutputStream());
			
			String fileName=br.readLine();
			File dir=new File("update");
			dir.mkdir();
			File file=new File(dir,fileName);
			if(file.exists()) {
				ps.println("存在");
				socket.close();
				return;
			}else {
				ps.println("不存在");
			}
			FileOutputStream fos=new FileOutputStream(file);
			byte[] arr=new byte[8192];
			int len;
			while((len=is.read(arr))!=-1) {
				fos.write(arr, 0, len);
			}
			fos.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
