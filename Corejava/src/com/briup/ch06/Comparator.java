package com.briup.ch06;
//比较器
public abstract class Comparator {
	//返回>0,s1>s2
	//返回<0,s1<s2
	//返回0,s1=s2
	public abstract int compare(Student s1,Student s2);
}
