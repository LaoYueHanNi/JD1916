package com.briup.ch05;

public class ShapeTest {
	
	public static void draw(Shape shape) {
		shape.draw();
	}
	public static void draw(Shape shape,String title) {
		shape.draw(title);
	}
	public static void main(String[] args) {
		Shape circle=new Circle(10, 20, 5);
		draw(circle);
		Shape rectangle=new Rectangle(0, 2, 3, 4);
		
	}
}
