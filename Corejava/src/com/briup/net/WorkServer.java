package com.briup.net;

//1.网络编程(TCP协议)
//客户端向服务器上传文件
//客户端
// 1.提示输入要上传的文件路径File，验证路径是否存在以及是否是文件夹
// 2.发送文件名到服务器
// 6.接收结果，如果存在给予提示，否则程序直接退出
// 7.如果不存在，定义FileInputStream读取文件，通过网络上传
// 
// 服务器
// 3.建立多线程服务器
// 4.读取文件名
// 5.判断文件名是否存在，将结果返回给客户端
// 8.接收文件 
import java.net.*;
import java.util.*;
import java.io.*;

public class WorkServer {
	private ServerSocket ss;
	private Set<Socket> clients;
	public WorkServer() {
		try {
			ss=new ServerSocket(7777);
			System.out.println("服务器端7777已启动");
			while(true) {
				Socket socket=ss.accept();
				new FileThread(socket).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new WorkServer();
	}
}
class FileThread extends Thread{
	private Socket currentsocket;
	public FileThread(Socket currentsocket) {
		this.currentsocket=currentsocket;
	}
	public void run() {
		BufferedReader br=null;
		PrintWriter pw=null;
		File file=null;
		FileInputStream fis;
		FileOutputStream fos;
		try {
			br=new BufferedReader(new InputStreamReader(currentsocket.getInputStream()));
			String str=br.readLine();
			file=new File(str);
			pw=new PrintWriter(currentsocket.getOutputStream());
			pw.println(file.exists());
			fis=new FileInputStream(file);
			fos=new FileOutputStream("src/com/briup/net/download");
			br.readLine();
			int result=-1;//读到字节
			while((result=fis.read())!=-1) {
				System.out.print((char)result);
				fos.write(result);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
}