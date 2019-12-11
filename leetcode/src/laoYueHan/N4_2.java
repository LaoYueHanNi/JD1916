package laoYueHan;

public class N4_2 {
	public static void main(String[] args) {
		System.out.println(new N4_2().print(23));
	}
	public int print(int num) {
		if(num%9==0) {
			return 9;
		}
		return num%9;
	}
}
