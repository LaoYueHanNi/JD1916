package com.briup.ch05;

public class Shape {
	
	private int x,y;//��'
	public void draw() {
		
	}
	
	public Shape(int x,int y){
		setX(x);
		setY(y);
	}

	public void setX(int x) {
		this.x=x;
	}
	public void setY(int y) {
		this.y=y;
	}
	
	public void draw(String title) {
		System.out.println("title:"+title);
		draw();
	}
}
