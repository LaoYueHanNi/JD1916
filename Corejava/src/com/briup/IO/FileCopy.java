package com.briup.IO;
import java.io.*;
//��һ���ļ�����������һ���ļ�
public class FileCopy {
	public static void main(String[] args) {
	//��ȡ�ļ����ݵ���
		FileInputStream fis=null;
	//���
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream("src/com/briup/IO/FileCopy.java");
			fos=new FileOutputStream("src/com/briup/IO/a.txt");
			
			int result=-1;//�����ֽ�
			while((result=fis.read())!=-1) {
				System.out.print((char)result);
				fos.write(result);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//�ͷ�
			try {
				fos.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}