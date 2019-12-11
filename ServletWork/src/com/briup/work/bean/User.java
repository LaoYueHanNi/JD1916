package com.briup.work.bean;

//定义一个用户类,再写构造setget方法
public class User {
	private int id;
	private String username;
	private String password;
	private String hobby;
	private int age;
	private String city;
	private String motto;
	private String gender;

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", hobby=" + hobby + ", age="
				+ age + ", city=" + city + ", motto=" + motto + ", gender=" + gender + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
