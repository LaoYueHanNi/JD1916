package com.briup.net;

//1.������(TCPЭ��)
//�ͻ�����������ϴ��ļ�
//�ͻ���
// 1.��ʾ����Ҫ�ϴ����ļ�·��File����֤·���Ƿ�����Լ��Ƿ����ļ���
// 2.�����ļ�����������
// 6.���ս����������ڸ�����ʾ���������ֱ���˳�
// 7.��������ڣ�����FileInputStream��ȡ�ļ���ͨ�������ϴ�
// 
// ������
// 3.�������̷߳�����
// 4.��ȡ�ļ���
// 5.�ж��ļ����Ƿ���ڣ���������ظ��ͻ���
// 8.�����ļ� 
import java.net.*;
import java.util.*;
import java.io.*;

public class WorkServer {
	private ServerSocket ss;
	private Set<Socket> clients;
	public WorkServer() {
		try {
			ss=new ServerSocket(7777);
			System.out.println("��������7777������");
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
			int result=-1;//�����ֽ�
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