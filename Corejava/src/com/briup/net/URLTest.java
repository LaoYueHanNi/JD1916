package com.briup.net;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.*;
public class URLTest {
	public static void main(String[] args) throws Exception {
		//创建URL对象
		URL url=new URL("http://www.baidu.com/a.png");
		//获取输入流
		InputStream is=url.openStream();
		//写入本地文件中
		FileOutputStream fos=new FileOutputStream("src/com/briup/net/b.png");
		byte[] buff=new byte[1024];
		int len=-1;
		if((len=is.read(buff))!=-1) {
			fos.write(buff,0,len);
		}
		fos.flush();
		fos.close();
	}
}
