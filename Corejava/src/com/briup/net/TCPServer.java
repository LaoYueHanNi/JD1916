package com.briup.net;
import java.net.*;
import java.io.*;
//��������
public class TCPServer {
	public static void main(String[] args) {
		ServerSocket ss=null;
		Socket socket=null;
		BufferedReader br=null;
		PrintWriter pw=null;
		try {
			//1����serverSocket����,���󶨶˿ں�
			ss=new ServerSocket(9999);
			System.out.println("���������Ѿ���9999�˿�����...");
			while(true) {
				//2.�ȴ��ͻ�������accept(),����������
				socket=ss.accept();
				//3.�ȶ�ȡ�ͻ��˷��͹���������
				InputStream is=socket.getInputStream();
				br=new BufferedReader(new InputStreamReader(is));
				String msg=br.readLine();
				System.out.println("�ͻ���˵:"+msg);
				//4�������ݸ��ͻ���
				pw=new PrintWriter(socket.getOutputStream());
				pw.println(new java.util.Date());
				pw.flush();
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//5�ر���Դ(�ȿ��ĺ��)
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
