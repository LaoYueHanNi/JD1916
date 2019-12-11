package n1_100;
/*编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。*/

public class N14 {
	public String ongestCommonPrefix(String[] strs) {
		String result = "";
		if (strs == null || strs.length == 0) {
			return result;
		} else {
			String temp = strs[0];
			if (temp.length() == 0)
				return result;
			boolean t = true;
			for (int i = 0; i < temp.length(); i++) {
				int j = 0;
				for (String s : strs) {
					if (j > 0) {
						if(s.length()>=i+1) {
							if (!temp.substring(0, i + 1).equals(s.substring(0, i + 1))) {
								t = false;
							}
						}else {
							t=false;
						}
					}
					j++;
				}
				if (t == true) {
					result = temp.substring(0, i+1);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String[] str = { "xius", "xisa", "sifd" };
		String[] strs = { "flower","flow","flight" };
		String[] s = { "a" };
		System.out.println(new N14().ongestCommonPrefix(strs));
	}
}
