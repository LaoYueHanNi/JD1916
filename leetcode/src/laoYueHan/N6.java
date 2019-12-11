package laoYueHan;

import java.util.*;

public class N6 {
	public static void main(String[] args) {
		N6 n6=new N6();
		String s="";
		String[] words= {};
		System.out.println(n6.findSubstring(s, words));
	}

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> list = new ArrayList<Integer>();// 返回值
		if (words.length == 0) {
			return list;
		} else {
			// char[] str=s.toCharArray();
			Map<String, Integer> wm = new HashMap<String, Integer>();// words中个单词出现的次数,因为单词可以重复
			for (String word : words) {
				wm.put(word, (wm.getOrDefault(word, 0)) + 1);// 来一个单词,加1,重复的话覆盖添加,values加1
			}

			int len = words[0].length();// 保存words中单词的长度
			for (int i = 0; i < s.length() - (len * words.length - 1); i++) {
				boolean t = false;
				Map<String, Integer> sm = new HashMap<String, Integer>();
				for (int j = 0; j < words.length; j++) {
					String sWord = s.substring(i + j * len, i + (j + 1) * len);
					sm.put(sWord, sm.getOrDefault(sWord, 0) + 1);// 记录s中单词的个数
				}
				Set keys = wm.keySet();
				for (Object key : keys) {
					if (wm.get(key) != sm.get(key)) {
						t = false;
						break;
					}
					if (wm.get(key) == sm.get(key)) {
						t = true;
					}
				}
				if (t) {
					list.add(i);
				}
			}
			return list;
		}
	}
}
