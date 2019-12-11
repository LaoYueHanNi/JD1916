package exam;

public class monkey {

	public static void main(String args[]) {
		int M = 50000;// 猴子总数
		int N = 3000;// 规定淘汰的数字编号

		int monkeynum[] = new int[M];
		for (int i = 0; i < monkeynum.length; i++) {
			monkeynum[i] = i + 1;
		}

		int count = 1;// 循环计数
		int king = 0;// 猴子大王的编号
		int index = 0;// 数组的下标

		while (M != 0) {
			// 首先先把单数组变成一个循环数组，就是循环到数组的末尾时，把数组的下标制成数组的开始
			if (index == monkeynum.length) {
				index = 0;
			}
			// 然后判断循环计数的情况
			if (count == N && monkeynum[index] != 0) {
				monkeynum[index] = 0;
				M--;
				count = 1;
			}

			if (monkeynum[index] != 0) {
				count++;
			}
			index++;
		}
		king = index;
		System.out.println("猴子的大王的编号是" + king);
	}
}
