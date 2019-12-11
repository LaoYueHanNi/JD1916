package com.briup.IO;

import java.io.*;

//���̸߳��Ʋ���
public class Random {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("��ʼ����");
		//Դ�ļ�
		String path1="src/com/briup/IO/a.txt";
		//Ŀ���ļ�
		String path2="src/com/briup/IO/f ";
		Thread[] threads=new Thread[3];
		File file=new File(path1);
		long length=file.length();
		for(int i=0;i<3;i++) {
			ReadRandom from=new ReadRandom(path1);
			WriteRandom to=new WriteRandom(path2);
			threads[i]=new WorkCopy(i/3*length, (i+1)/3*length, from, to);
			threads[i].start();
			threads[i].join();//�ȴ�
		}
		System.out.println("���ƽ���");
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
	private long begin;// ��ʼλ��
	private long end;// ����λ��
	private ReadRandom from;// ������
	private WriteRandom to;// д����

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
