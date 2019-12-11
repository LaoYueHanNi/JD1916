package com.briup.enums;

public enum BigDataClass {
	L1("初级工程师",1000),L2("高级工程师",15000),
	L3("架构师",20000),L4("CEO",30000);
	private String level;
	private int money;
	private BigDataClass(String level,int money) {
		this.level=level;
		this.money=money;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public static void select(BigDataClass bigDataClass) {
		switch(bigDataClass){
			case L1:
				System.out.println(L1.level);
				break;
			case L2:
				System.out.println(L2.level);
				break;
			case L3:
				System.out.println(L3.level);
				break;
			case L4:
				System.out.println(L4.level);
				break;
			default:
				System.out.println("没这级别");
				break;
		}
	}
}
