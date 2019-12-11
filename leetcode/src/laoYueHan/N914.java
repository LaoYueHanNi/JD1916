package laoYueHan;

//给定一副牌，每张牌上都写着一个整数。
//
//此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
//
//每组都有 X 张牌。
//组内所有的牌上都写着相同的整数。
//仅当你可选的 X >= 2 时返回 true。

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class N914 {
	public boolean hasGroupsSizeX(int[] deck) {
		int N = deck.length;
		boolean result = false;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Set keys= map.keySet();
		for (int temp : deck) {
			map.put(temp, map.getOrDefault(temp, 0) + 1);
		}
		
		find: for(int x=2;x<=N;x++) {
			if(N%x==0) {
				for(Object key:keys) {
					if(map.get(key)%x!=0) {
						continue find;
					}
				}
				result=true;
			}
		}
		return result;
	}
}
