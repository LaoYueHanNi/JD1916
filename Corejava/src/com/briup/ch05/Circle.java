package com.briup.ch05;

public class Circle extends Shape {
	private  int radius;
	private int x,y;//��
	
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
		System.out.println("��һԲ��Բ����("+getX()+","+getY()+")"+"�뾶��"+getRadius());
	}
}
