package laoYueHan;
//����һ���������� arr�������æͳ��������ÿ�����ĳ��ִ�����

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sun.jdi.Value;

//���ÿ�����ĳ��ִ������Ƕ�һ�޶��ģ��ͷ��� true�����򷵻� false��

public class N1027 {
	public boolean uniqueOccurrences(int[] arr) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();// ����HashMap�����洢���������ֵĴ���
		boolean result = true;// ���淵�ؽ��
		List list = new ArrayList();// �����洢valueֵ

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);// ���������ֵĴ����Լ�ֵ����ʽ����
		}
		for (Integer temp : map.values()) {
			// ��values�洢��list
			list.add(temp);
		}
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				// ѭ���ȴ�С,����ͬ��returnfaluse
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
