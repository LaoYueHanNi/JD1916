package laoYueHan;
//给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sun.jdi.Value;

//如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。

public class N1027 {
	public boolean uniqueOccurrences(int[] arr) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();// 创建HashMap用来存储数与数出现的次数
		boolean result = true;// 储存返回结果
		List list = new ArrayList();// 用来存储value值

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);// 数与数出现的次数以键值对形式保存
		}
		for (Integer temp : map.values()) {
			// 将values存储到list
			list.add(temp);
		}
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				// 循环比大小,有相同就returnfaluse
				if (list.get(i) == list.get(j)) {
					result = false;
					return result;
				}

			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 3, 2, 1, 4, 3 };
		System.out.println(new N1027().uniqueOccurrences(arr));
	}
}
