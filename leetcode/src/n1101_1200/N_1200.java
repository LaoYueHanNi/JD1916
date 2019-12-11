package n1101_1200;

import java.util.ArrayList;
import java.util.Arrays;
/*������������� arr������ÿ��Ԫ�ض� ����ͬ��
�����ҵ����о�����С���Բ��Ԫ�ضԣ����Ұ������˳�򷵻ء�
2 <= arr.length <= 10^5
-10^6 <= arr[i] <= 10^6*/
import java.util.List;

public class N_1200 {
	/*
	 * public static void main(String[] args) { int[] arr = {4,2,1,3};
	 * System.out.println(new N_1200().minimumAbsDifference(arr)); }
	 */

	public List<List<Integer>> minimumAbsDifference(int[] arr) {

		List<List<Integer>> listM = new ArrayList();// ����ĸ���ϴ�ŷ���ֵ
		List<Integer> listC = new ArrayList<Integer>();// �����Ӽ��ϴ��һ��Ԫ��
		int minOld = (int) Math.pow(10, 6);// ������С��ֵ
		int minNew = 0; // �����²�ֵ,�����Ƚ�

		Arrays.sort(arr);// ��������
		for (int i = 0; i < arr.length - 1; i++) {
			minNew = arr[i + 1] - arr[i];
			if (minNew < minOld) {
				// �µĲ�ֵ��С,�����ĸ����,����Ӽ���Ԫ��,ĸ��������Ӽ���
				listM = null;
				listC.add(arr[i], arr[i + 1]);
				listM.add(listC);
			}
			if (minNew == minOld)
				listM.add(listC);
			minOld = minNew;
			listC = null;// ÿһ�����һ���Ӽ���
		}

		return listM;
	}
}
