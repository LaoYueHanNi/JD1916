package com.briup.net;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.*;
public class URLTest {
	public static void main(String[] args) throws Exception {
		//����URL����
		URL url=new URL("http://www.baidu.com/a.png");
		//��ȡ������
		InputStream is=url.openStream();
		//д�뱾���ļ���
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
