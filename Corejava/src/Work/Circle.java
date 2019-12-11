package Work;

public class Circle extends Shape {
	private double r;// �뾶

	public Circle() {
		r = 1.0;
	}

	public Circle(int r) {
		this.r = r;
	}

	public Circle(int x, int y, int r) {
		super();
		this.r = r;
	}

	public void draw() {
		System.out.println("draw in circle" + x + y + r);
	}
}
