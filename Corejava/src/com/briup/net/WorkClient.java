package com.briup.net;
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
import java.util.*;
public class WorkClient {
	public static void main(String[] args) {
		//File file=null;
		FileInputStream fis=null;
		PrintWriter pw=null;
		Socket socket=null;
		BufferedReader br=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("����Ҫ�ϴ����ļ�·��:");
		String inFile=sc.nextLine();
		try {
			socket=new Socket("127.0.0.1",7777);
			//file=new File(inFile);
			fis=new FileInputStream(inFile);
			pw=new PrintWriter(socket.getOutputStream());
			pw.println(inFile);
			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			if(br.ready()) {
				System.out.println("���ļ�����");
			}else {
				char[] arr=new char[8192];
				int result=-1;//�����ֽ�
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
