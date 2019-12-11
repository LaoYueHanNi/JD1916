package com.briup.IO;

import java.io.*;

public class BufferedTest2 {
	public static void main(String[] args) {
		BufferedReader br=null;
		//BufferedWriter bw=null;
		PrintWriter pw=null;
		
		try {
			br=new BufferedReader(new FileReader("src/com/briup/IO/a.txt"));
			//bw=new BufferedWriter(new FileWriter("src/com/briup/IO/d.txt"));
			pw=new PrintWriter("src/com/briup/IO/d.txt");
			
			String line =null;
			while((line=br.readLine())!=null) {
				System.out.println(line);
				//bw.write(line);
				//bw.newLine();//»»ÐÐ
				pw.println(line);
			}
			//bw.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
				try {
					if(br!=null)br.close();
					//if(bw!=null)bw.close();
					if(pw!=null)pw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
