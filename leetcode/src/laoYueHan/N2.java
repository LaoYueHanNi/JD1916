package laoYueHan;

import java.util.*;

//����һ�� 32 λ���з�������������Ҫ�����������ÿλ�ϵ����ֽ��з�ת��

public class N2 {
	public static void main(String[] args) {
		System.out.println(new N2().reverse(-321));
	}
	public int reverse(int x) {
		if(x==0) {
			return 0;
		}
		List<Integer> list=new ArrayList<Integer>();
		while(x!=0) {
			list.add(x%10);
			x=x/10;
		}
		
		int j=1;
		long result=0;
		for(int temp:list) {
			result+=temp*(Math.pow(10, list.size()-j));
			j++;
			
		}
		if(result>Math.pow(2, 31)||result<-Math.pow(2, 31)) {
			return 0;
		}
		return (int)result;
		
	}
}
