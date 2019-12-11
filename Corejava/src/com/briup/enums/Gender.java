package com.briup.enums;

public enum Gender {
	male,female;
	public static void main(String[] args) {
		Gender[] g=Gender.values();
		for(Gender g2:g) {
			System.out.println(g2);
		}
		Gender g3=Gender.valueOf("male");
		System.out.println(g3);
		
	}
}
