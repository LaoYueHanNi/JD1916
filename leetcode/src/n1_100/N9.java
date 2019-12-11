package n1_100;



//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 12345
public class N9 {
	public boolean isPalindrome1(int x) {
	
		
		if(x<0)return false;//负数直接枪毙
		
		char[] numString = Integer.toString(x).toCharArray();//将int转化为char[]的数组
		int index = numString.length-1;
		for(int i =0; i <=index/2;i++) {
			if(numString[i] != numString[index-i] ) {
				//头尾对比,不同就false
				return false;
			}
		}
		return true;
	}
	public boolean isPalindrome2(int x) {
		String str = x+"";
		int len = str.length();
		for(int i = 0; i<len/2;i++) {
			if(str.charAt(i)!=str.charAt(len-i-1))return false;
		}
		return true;
	}
}
