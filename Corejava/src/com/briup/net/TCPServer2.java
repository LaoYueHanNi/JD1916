package com.briup.net;
import java.io.*;
import java.net.*;
public class TCPServer2 {
	private ServerSocket ss;
	public TCPServer2() {
		try {
			ss=new ServerSocket(9999);
			System.out.println("�������Ѿ�����");
			 while(true) {
				 Socket socket=ss.accept();
				 //�������߳�
				 new ServerThread(socket).start();
			 }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new TCPServer2();
	}
}
class ServerThread extends Thread{
	private Socket socket;
	public ServerThread(Socket socket) {
		this.socket=socket;
	}
	public void run() {
		
		try {
			//3.�ȶ�ȡ�ͻ��˷��͹���������
			InputStream is=socket.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			String msg=br.readLine();
			System.out.println("�ͻ���˵:"+msg);
			//4�������ݸ��ͻ���
			PrintWriter pw=new PrintWriter(socket.getOutputStream());
			pw.println(new java.util.Date());
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
