package n1_100;



//�ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ���������� 12345
public class N9 {
	public boolean isPalindrome1(int x) {
	
		
		if(x<0)return false;//����ֱ��ǹ��
		
		char[] numString = Integer.toString(x).toCharArray();//��intת��Ϊchar[]������
		int index = numString.length-1;
		for(int i =0; i <=index/2;i++) {
			if(numString[i] != numString[index-i] ) {
				//ͷβ�Ա�,��ͬ��false
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