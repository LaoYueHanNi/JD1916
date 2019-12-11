package com.briup.IO;
import java.io.*;
public class BufferedTest {
	public static void main(String[] args) {
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		//FileInputStream fis=null;
		try {
			//fis=new FileInputStream("src/com/briup/IO/a.txt");
			bis=new BufferedInputStream(new FileInputStream("src/com/briup/IO/a.txt"));
			bos=new BufferedOutputStream(new FileOutputStream("src/com/briup/IO/c.txt"));
			byte[] buff=new byte[512];
			int len=-1;
			while((len=bis.read(buff))!=-1) {
				System.out.println(new String(buff,0,len));
				bos.write(buff,0,len);
			}
			bos.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				//先开的先关
				//if(fis!=null)fis.close();
				if(bis!=null)bis.close();
				if(bos!=null)bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
