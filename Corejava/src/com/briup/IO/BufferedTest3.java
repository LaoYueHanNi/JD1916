package com.briup.IO;

import java.io.*;



public class BufferedTest3 {
	public static void main(String[] args) {
		BufferedReader br=null;
		BufferedWriter bw=null;
		try {
			//字节流转字符流
			br=new BufferedReader(
					new InputStreamReader(
					new FileInputStream("src/com/briup/IO/a.txt")));
			//字符流转字节流
			bw=new BufferedWriter(
					new OutputStreamWriter
					(new FileOutputStream("src/com/briup/IO/d.txt")));
			String line=null;
			while((line=br.readLine())!=null){
				System.out.println(line);
				bw.write(line);
				bw.newLine();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
				try {
					if(br!=null)br.close();
					if(bw!=null)bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}
}
