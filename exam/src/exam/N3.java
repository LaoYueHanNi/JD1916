package exam;

public class N3 {
	public static void main(String[] args) {
		int i = 23;
		int j = 3 & ++i;
		double t = 0.9F;
		
		System.out.println(i + " " + j);
		method1();
	}

	public  static int method1() {
		int num = 10;
		try {
			if (num < 20) {
				System.out.print("num is 10.");
				return num;
			}
			num = 40;
		} catch (Exception e) {
			System.out.print("num is 50.");
			num = 50;
		} finally {
			num = 60;
			System.out.print("num is 60.");
		}
		return num;
	}

}
