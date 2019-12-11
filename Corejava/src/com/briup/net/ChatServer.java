package com.briup.net;
import java.io.*;
import java.util.*;
import java.net.*;

public class ChatServer {
	private ServerSocket ss;
	private Set<Socket> clients;//  客户端集合
	public ChatServer() {
		try {
			ss=new ServerSocket(6755);
			clients=new HashSet<>();
			System.out.println("聊天室服务器端已启动");
			while(true) {
				Socket socket=ss.accept();
				System.out.println("有客户加入");
				clients.add(socket);
				//启动子线程
				new ChatThread(socket,clients).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ChatServer();
	}
}
//接受当前客户端的数据,并转发给所有客户端
class ChatThread extends Thread{
	private Socket currentsocket;//当前客户端
	private Set<Socket> clients;//所有客户端
	public ChatThread(Socket currentsocket,Set<Socket> clients) {
		this.currentsocket=currentsocket;
		this.clients=clients;
	}
	public void run() {
		BufferedReader br=null;
		try {
			br=new BufferedReader(new InputStreamReader(currentsocket.getInputStream()));
			String str=null;
			while((str=br.readLine())!=null) {
				//转发出去
				for(Socket emp:clients) {
					PrintWriter pw=new PrintWriter(emp.getOutputStream());
					pw.println(str);
					pw.flush();
				}
			}
		}catch(Exception e) {
			
		}finally {
			
		}
	}
}