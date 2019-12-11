package array;

import java.util.ArrayList;

//˳ʱ���ӡ����
//����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
//���磬�����������4 X 4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
//�����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
public class N1 {
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int len1 = matrix.length;// ����
		int len2 = matrix[0].length;// ����
		int cycleNum = 0;

		while (cycleNum * 2 < len1 && cycleNum * 2 < len2) {
			// һȦһȦ��ӡ
			printCycle(matrix, list, len1, len2, cycleNum);
			cycleNum++;
		}

		return list;
	}

	public void printCycle(int[][] matrix, ArrayList<Integer> list, int len1, int len2, int cycleNum) {
		int endx = len2 - cycleNum - 1;
		int endy = len1 - cycleNum - 1;

		// ���Ҵ�ӡ
		for (int i = cycleNum; i <= endx; i++) {
			list.add(matrix[cycleNum][i]);
		}
		// �ϵ��´�ӡ
		if (cycleNum < endy) {
			for (int i = cycleNum + 1; i <= endy; i++) {
				list.add(matrix[i][endx]);
			}
		}
		// �ҵ����ӡ
		if (cycleNum < endy && cycleNum < endx) {
			for (int i = endx - 1; i >= cycleNum; i--) {
				list.add(matrix[endy][i]);
			}
		}
		// ���µ��ϴ�ӡ
		if (cycleNum < endy - 1 && cycleNum < endx) {
			for (int i = endy - 1; i > cycleNum; i--) {
				list.add(matrix[i][cycleNum]);
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };// {13,14,15,16}
		System.out.println(new N1().printMatrix(matrix));
	}
}