package com.briup.ch05;

public class Hand {
	private int num;
	
	public Hand(int num) {
		setNum(num);
		
	}
	public void setNum(int num) {
		if(num<0||num>2) {
			this.num=0;
		}
		else {
			this.num=num;
		}
	}
	public int getNum() {
		return num;
	}
	public static void main(String[] args) {
		System.out.println("sdasa");
	}
}
