package Myself;

public class Point {
	private double x;
	private double y;
	public Point(double _x,double _y) {
		x=_x;
		y=_y;
	}
	public double getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public static double calDistance(Point p1,Point p2) {
		return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
	}
	public static void main(String[] args) {
		Point p1=new Point(1.0,2.1);
		Point p2=new Point(1.5,2.9);
		System.out.println(calDistance(p1, p2));
		
	}
}
