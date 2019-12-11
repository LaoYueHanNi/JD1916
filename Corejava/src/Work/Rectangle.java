package Work;

public class Rectangle extends Shape {
	private double height;
	private double width;
	public Rectangle() {
		this.height=1.0;
		this.width=1.0;
	}
	public Rectangle(int x,int y,double height, double width) {
		super();
		this.height = height;
		this.width = width;
	}
	public void draw() {
		System.out.println("draw in rectangle"+x+y+height+width);
	}
}
