package com.briup.net;
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
import java.util.*;
public class WorkClient {
	public static void main(String[] args) {
		//File file=null;
		FileInputStream fis=null;
		PrintWriter pw=null;
		Socket socket=null;
		BufferedReader br=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("输入要上传的文件路径:");
		String inFile=sc.nextLine();
		try {
			socket=new Socket("127.0.0.1",7777);
			//file=new File(inFile);
			fis=new FileInputStream(inFile);
			pw=new PrintWriter(socket.getOutputStream());
			pw.println(inFile);
			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			if(br.ready()) {
				System.out.println("该文件存在");
			}else {
				char[] arr=new char[8192];
				int result=-1;//读到字节
				while((result=fis.read())!=-1) {
					pw.write(arr,0,result);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
