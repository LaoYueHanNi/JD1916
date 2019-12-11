package com.briup.IO;

import java.io.*;

//多线程复制操作
public class Random {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("开始复制");
		//源文件
		String path1="src/com/briup/IO/a.txt";
		//目标文件
		String path2="src/com/briup/IO/f ";
		Thread[] threads=new Thread[3];
		File file=new File(path1);
		long length=file.length();
		for(int i=0;i<3;i++) {
			ReadRandom from=new ReadRandom(path1);
			WriteRandom to=new WriteRandom(path2);
			threads[i]=new WorkCopy(i/3*length, (i+1)/3*length, from, to);
			threads[i].start();
			threads[i].join();//等待
		}
		System.out.println("复制结束");
		System.out.println(file.getAbsoluteFile());
	}
}

class ReadRandom {
	private RandomAccessFile from;

	public ReadRandom(String path) throws IOException {
		from = new RandomAccessFile(path, "r");
	}

	public int read(long pos, byte[] buff) throws IOException {
		from.seek(pos);
		return from.read(buff);
	}
}

class WriteRandom {
	private RandomAccessFile to;

	public WriteRandom(String path) throws IOException {
		to = new RandomAccessFile(path, "rw");
	}

	public void write(long pos, byte[] buff, int len) throws IOException {
		to.seek(pos);
		to.write(buff, 0, len);
	}
}

class WorkCopy extends Thread {
	private long begin;// 开始位置
	private long end;// 结束位置
	private ReadRandom from;// 读数据
	private WriteRandom to;// 写数据

	public WorkCopy(long begin, long end, ReadRandom from, WriteRandom to) {
		this.begin = begin;
		this.end = end;
		this.from = from;
		this.to = to;
	}

	public void run() {
		try {
			byte[] buff = new byte[1024];
			while (begin < end) {
				int len = from.read(begin, buff);
				if(begin+len>end) {
					len=(int)(end-begin);
				}
				to.write(begin, buff, len);
				begin += len;
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
