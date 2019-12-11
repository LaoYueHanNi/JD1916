package com.briup.net;

import java.net.ServerSocket;

//1.������(TCPЭ��)
//�ͻ�����������ϴ��ļ�
//�ͻ���
//1.��ʾ����Ҫ�ϴ����ļ�·��File����֤·���Ƿ�����Լ��Ƿ����ļ���
//2.�����ļ�����������
//6.���ս����������ڸ�����ʾ���������ֱ���˳�
//7.��������ڣ�����FileInputStream��ȡ�ļ���ͨ�������ϴ�
//
//������
//3.�������̷߳�����
//4.��ȡ�ļ���
//5.�ж��ļ����Ƿ���ڣ���������ظ��ͻ���
//8.�����ļ� 
import java.io.*;
import java.net.*;
public class WorkServer1 {
	public static void main(String[] args) {	
		ServerSocket ss=null;
		Socket socket=null;
		try {
			ss=new ServerSocket(7657);
			System.out.println("��������7657������");
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
				ps.println("����");
				socket.close();
				return;
			}else {
				ps.println("������");
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
