package com.briup.bean;

public class LifeBean {
	private String name;
	 
	public LifeBean() {
		System.out.println("Bean�����");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void init() {
		this.name="zs";
		System.out.println(",,,,,,,,");
	}

	@Override
	public String toString() {
		return "LifeBean [name=" + name + "]";
	}
	
	public void destory() {
		//�ر���Դ
		System.out.println("destory");
	}
}
