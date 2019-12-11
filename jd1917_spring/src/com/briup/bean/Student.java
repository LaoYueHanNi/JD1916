package com.briup.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.BeanNameAware;


public class Student implements BeanNameAware{
	private Integer id;
	private String name;
	private String gender;
	private int age;
	private Address address;
	private List<String> list;
	private Set<String> set;
	private Map<Integer,Student> map;
	private Properties pros;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	public Map<Integer, Student> getMap() {
		return map;
	}
	public void setMap(Map<Integer, Student> map) {
		this.map = map;
	}
	public Properties getPros() {
		return pros;
	}
	public void setPros(Properties pros) {
		this.pros = pros;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", address=" + address
				+ ", list=" + list + ", set=" + set + ", map=" + map + ", pros=" + pros + "]";
	}
	private String beanName;
	@Override
	public void setBeanName(String arg0) {
		this.beanName=arg0;
	}
	public String getBeanName() {
		return beanName;
	}
	
}
