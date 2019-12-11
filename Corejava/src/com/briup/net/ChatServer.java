package com.briup.net;
import java.io.*;
import java.util.*;
import java.net.*;

public class ChatServer {
	private ServerSocket ss;
	private Set<Socket> clients;//  �ͻ��˼���
	public ChatServer() {
		try {
			ss=new ServerSocket(6755);
			clients=new HashSet<>();
			System.out.println("�����ҷ�������������");
			while(true) {
				Socket socket=ss.accept();
				System.out.println("�пͻ�����");
				clients.add(socket);
				//�������߳�
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
//���ܵ�ǰ�ͻ��˵�����,��ת�������пͻ���
class ChatThread extends Thread{
	private Socket currentsocket;//��ǰ�ͻ���
	private Set<Socket> clients;//���пͻ���
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
				//ת����ȥ
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