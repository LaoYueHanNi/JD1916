package n1101_1200;

import java.util.ArrayList;
import java.util.Arrays;
/*给你个整数数组 arr，其中每个元素都 不相同。
请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
2 <= arr.length <= 10^5
-10^6 <= arr[i] <= 10^6*/
import java.util.List;

public class N_1200 {
	/*
	 * public static void main(String[] args) { int[] arr = {4,2,1,3};
	 * System.out.println(new N_1200().minimumAbsDifference(arr)); }
	 */

	public List<List<Integer>> minimumAbsDifference(int[] arr) {

		List<List<Integer>> listM = new ArrayList();// 定义母集合存放返回值
		List<Integer> listC = new ArrayList<Integer>();// 定义子集合存放一对元素
		int minOld = (int) Math.pow(10, 6);// 定义最小差值
		int minNew = 0; // 定义新差值,用来比较

		Arrays.sort(arr);// 数组排序
		for (int i = 0; i < arr.length - 1; i++) {
			minNew = arr[i + 1] - arr[i];
			if (minNew < minOld) {
				// 新的差值更小,则清空母集合,添加子集合元素,母集合添加子集合
				listM = null;
				listC.add(arr[i], arr[i + 1]);
				listM.add(listC);
			}
			if (minNew == minOld)
				listM.add(listC);
			minOld = minNew;
			listC = null;// 每一轮清空一次子集合
		}

		return listM;
	}
}
