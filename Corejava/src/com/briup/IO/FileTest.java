package com.briup.IO;
//测试File对象
import java.io.*;
public class FileTest {
	public static void main(String[] args) throws IOException {
		File file=new File("src/com/briup/IO/emp.txt");
		//File file=new File("src/com/briup/IO/","emp.txt");
		
		System.out.println(file.exists());
		if(!file.exists()) {
			//创建新的文件
			//file.createNewFile();
			//创建新的目录
			file.mkdir();
		}
		System.out.println(file.length());
	}
}
