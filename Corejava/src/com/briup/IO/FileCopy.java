package com.briup.IO;
import java.io.*;
//把一个文件拷贝到另外一个文件
public class FileCopy {
	public static void main(String[] args) {
	//读取文件数据的流
		FileInputStream fis=null;
	//输出
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream("src/com/briup/IO/FileCopy.java");
			fos=new FileOutputStream("src/com/briup/IO/a.txt");
			
			int result=-1;//读到字节
			while((result=fis.read())!=-1) {
				System.out.print((char)result);
				fos.write(result);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//释放
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
