package com.briup.IO;
import java.io.*;
public class RandomAccessFileTest {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("src/com/briup/IO/RandomAccessFileTest.java","r");
		raf.seek(264);//跳过多少字节
		String line=raf.readLine();
		System.out.println(line);
		raf.seek(264);
		raf.write("//hello world".getBytes());
	}
	
}
