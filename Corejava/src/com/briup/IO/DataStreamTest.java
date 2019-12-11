 package com.briup.IO;

import java.io.*;

public class DataStreamTest {
	public static void main(String[] args) {
		DataOutputStream dos=null;
		DataInputStream dis=null;
		try {
			dos=new DataOutputStream(new FileOutputStream("src/com/briup/IO/data"));
			dos.writeInt(10);
			dos.writeBoolean(false);
			dos.writeDouble(34.0);
		}catch(IOException e) {
			
		}
	}
}
