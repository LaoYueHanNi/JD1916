package com.briup.ch05;

public class Person {
		
		public int age;
		public String name;
		public int saraly;
		public boolean male;
		private Address address;
		
		public Person(String name,boolean male,int age,int saraly) {
			Hand h = new Hand(2);
		}
		
		public void setName(String name) {
			this.name=name;
		}
		public void setAge(int age) {
			this.age=age;
		}
		public void setMale(boolean male) {
			this.male=male;
		}
		public void setSaraly(int saraly) {
			this.saraly=saraly;       
		}
		
		public void setAddress(Address address) {
			this.address=address;
		}
}
