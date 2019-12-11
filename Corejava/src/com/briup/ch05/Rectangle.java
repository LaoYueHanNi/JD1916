package com.briup.ch05;

public class Rectangle extends Shape {
	private int x,y;
	private int chang;
	private int kuan;
	
	public Rectangle(int x,int y,int kuan,int chang) {
		super(x, y);
		setChang(chang);
		setKuan(kuan);
	}
	public void setChang(int chang) {
		this.chang = chang;
	}
	
	public void setKuan(int kuan) {
		this.kuan = kuan;
	}
	
	public int getChang() {
		return chang;
	}
	public int getKuan() {
		return kuan;
	}
	
}
