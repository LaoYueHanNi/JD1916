package com.briup.IO;
//����File����
import java.io.*;
public class FileTest {
	public static void main(String[] args) throws IOException {
		File file=new File("src/com/briup/IO/emp.txt");
		//File file=new File("src/com/briup/IO/","emp.txt");
		
		System.out.println(file.exists());
		if(!file.exists()) {
			//�����µ��ļ�
			//file.createNewFile();
			//�����µ�Ŀ¼
			file.mkdir();
		}
		System.out.println(file.length());
	}
}
