package n1_100;

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
public class N5 {
	//双循环下标,判断字串是否为回文字符串,跟新result的和length的值,小于length的值不进入循环
	public String longestPalindrome(String s) {
		String result = "";//定义结果字符串

		//判断字符串不为空
		if (s != "") {
			String temp = "";//临时字符串,充当子串
			int length = 0;//result的长度
			//双循环
			for (int left = 0; left < s.length(); left++) {
				for (int right = left + 1; right <= s.length(); right++) {
					//判断字串的长度是否大于length,大于才能进入判断
					if (length < right - left) {
						//子串
						temp = s.substring(left, right);
						//判断是否是回文字符串
						if (isPalindrome2(temp)) {
							//更新length和result的值
							length = right - left;
							result = temp;
						}
					}
				}
			}
		}
		//返回result字符串
		return result;
	}

	// 判断一个数是否是回文数:方法1
	public boolean isPalindrome1(String str) {

		String str1 = "";
		char[] c = str.toCharArray();

		for (int i = c.length - 1; i >= 0; i--) {
			str1 = str1 + c[i];
		}
		if (str1.equals(str)) {
			return true;
		}
		return false;
	}

	// 判断一个数是否是回文数:方法2
	public boolean isPalindrome2(String str) {
		int len = str.length();
		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) != str.charAt(len - i - 1))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		// String s1 = "";
		System.out.println(new N5().longestPalindrome(s));
		// System.out.println(new N5().isPalindrome(s1));
	}
}
