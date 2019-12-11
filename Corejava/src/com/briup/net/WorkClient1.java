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

public class WorkClient1 {
	public static void main(String[] args) {
		File file = getFile();
		BufferedReader br = null;
		PrintStream ps = null;
		try {
			Socket socket = new Socket("127.0.0.1", 7657);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			ps = new PrintStream(socket.getOutputStream());
			ps.println(file.getName());

			String result = br.readLine();
			if ("存在".equals(result)) {
				System.out.println("您上传的文件已存在,请不要重复上传");
				socket.close();
				return;
			}
			FileInputStream fis = new FileInputStream(file);
			byte[] arr = new byte[8192];
			int len;
			while ((len = fis.read(arr)) != -1) {
				ps.write(arr, 0, len);
			}
			fis.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static File getFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入要上传的文件路径:");
		while (true) {
			String line = sc.nextLine();
			File file = new File(line);
			if (!file.exists()) {
				System.out.println("您录入的文件路径不存在,请重新录入:");
			} else if (file.isDirectory()) {
				System.out.println("您录入的是文件夹路径,请输入一个文件路径");
			} else {
				return file;
			}
		}

	}
}
