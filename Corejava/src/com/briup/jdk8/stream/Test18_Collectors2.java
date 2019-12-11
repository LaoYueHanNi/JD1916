package com.briup.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * partitioningBy �ָ�
 */
public class Test18_Collectors2 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("test","hello","world","java","tom","C","javascript");
		
		//��stream�е��ַ��� ���� �Ƿ����java�Ӵ� ���зָ�ֳ������֣�
		//���մ�ŵ�map������
		Map<Boolean, List<String>> collect = 
				list.stream().collect(Collectors.partitioningBy(s->s.indexOf("java")!=-1));
		
		for(Boolean b : collect.keySet()){
			System.out.println(b+" : "+collect.get(b).size());
		}
		
	}
}
