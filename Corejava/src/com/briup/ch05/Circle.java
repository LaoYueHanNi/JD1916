package com.briup.ch05;

public class Circle extends Shape {
	private  int radius;
	private int x,y;//点
	
	public Circle(int x,int y,int radius) {
		super(x,y);
		setRadius(radius);
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public int getRadius() {
		return radius;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	@Override
	public void draw() {
		System.out.println("画一圆，圆心在("+getX()+","+getY()+")"+"半径是"+getRadius());
	}
}
