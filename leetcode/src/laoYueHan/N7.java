package laoYueHan;
/*给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
示例：
输入: S = "ADOBECODEBANC", T = "ABC"
输出: "BANC"*/

//
import java.util.*;


//弟弟代码,当s="ab",t="A";时会报错
public class N7 {
	public static void main(String[] args) {
		String s="abcdfa";
		String t="acd";
		N7 n7=new N7();
		System.out.println(n7.minWindow(s, t));
	}
	 public String minWindow(String s, String t) {
		String result="";
		if(s==null||t==null) {
			return result;
		}
		if(s.length()<t.length()) {
			return result;
		}
		if(s.length()==t.length()) {
			if(s==t)return s;
			if(s!=t)return result;
		}
		boolean bool=false;
		List<String> list=new ArrayList<String>();
		
		int len1=t.length();
		int len2=s.length();
		char[] tChar=t.toCharArray();
		Map<Character,Integer> m1=new HashMap<Character, Integer>();
		for(char temp:tChar) {
			m1.put(temp, m1.getOrDefault(temp, 0)+1);
		}
		//System.out.println(m1);
		Set keys = m1.keySet();
		A:for(int i=0;i<(len2-len1+1);i++) {
			B:for(int j=(i+len1);j<len2+1;j++) {
				String str=s.substring(i,j);
				Map<Character,Integer> m2=new HashMap<Character, Integer>();
				char[] sChar=str.toCharArray();
				for(char temp:sChar) {
					m2.put(temp, m2.getOrDefault(temp, 0)+1);
				}
				C:for (Object key : keys) {
					if(m2.get(key)==null) {
						bool=false;
						break C;
					}
					if(m2.get(key)>=m1.get(key)) {
						bool=true;
					}
					if(m2.get(key)<m1.get(key)) {
						bool=false;
						break C;
					}
				}
				if(bool) {
					list.add(str);
					list.get(i).length();
					
					
				}
			}
		}
		if(list!=null) {
			result=list.get(0);
			for(int i=1;i<list.size();i++) {
				if(list.get(i).length()<result.length()) {
					result=list.get(i);
				}
			}
		}
		
		return result;
	 }
}
