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
			if ("����".equals(result)) {
				System.out.println("���ϴ����ļ��Ѵ���,�벻Ҫ�ظ��ϴ�");
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
		System.out.println("����Ҫ�ϴ����ļ�·��:");
		while (true) {
			String line = sc.nextLine();
			File file = new File(line);
			if (!file.exists()) {
				System.out.println("��¼����ļ�·��������,������¼��:");
			} else if (file.isDirectory()) {
				System.out.println("��¼������ļ���·��,������һ���ļ�·��");
			} else {
				return file;
			}
		}

	}
}
