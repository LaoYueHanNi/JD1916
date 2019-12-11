package com.briup.jdk8;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierTest {
	public static void main(String[] args) {
		//����һ����λ������ַ���
		Supplier<String> f = ()->{
			String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
			Random random = new Random();     
			StringBuffer sb = new StringBuffer();     
			for (int i = 0; i < 8; i++) {  
				//����[0,base.length)֮��������
				int number = random.nextInt(base.length());     
				sb.append(base.charAt(number));     
			}     
			return sb.toString();   
		};
		System.out.println(f.get());
	}
}
