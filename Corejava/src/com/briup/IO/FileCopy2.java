package com.briup.IO;
import java.io.*;
public class FileCopy2 {
	public static void main(String[] args) {
		FileReader fr=null;
		FileWriter fw=null;
		try {
			fr=new FileReader("src/com/briup/IO/a.txt");
			fw=new FileWriter("src/com/briup/IO/b.txt");
			
			int result=-1;
			while((result=fr.read())!=-1) {
				System.out.print((char)result);
				fw.write(result);
			}
			fw.flush();
		}catch(IOException e) {
			
		}finally {
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
