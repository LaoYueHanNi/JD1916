package n1_100;
import java.util.HashMap;
import java.util.Map;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
public class N3 {
	public int lengthOfLongestSubstring(String s) {
		int answer = 0, left = 0;// 定义结果,窗口的左点
		Map<Character, Integer> map = new HashMap<Character, Integer>();// 定义hashmap作为窗口/利用往map中存放相同key元素会覆盖的特性
		// 定义右点,创建循环
		for (int right = 0; right < s.length(); right++) {
			// 判断map中是否含有右点所在元素,有就说明有一个元素重复了
			// 就要更新左点的位置,在map中出现重复元素的value和原左点挑选一个大值作为新左点
			if (map.containsKey(s.charAt(right))) {
				left = Math.max(map.get(s.charAt(right)), left);
			}
			// 更新答案数值,
			answer = Math.max(answer, right - left + 1);
			// 往map中添加元素,+1是因为方便更新左点时可以直接放在重复元素的下一个点
			map.put(s.charAt(right), right + 1);
		}
		// 返回答案
		return answer;
	}
}
