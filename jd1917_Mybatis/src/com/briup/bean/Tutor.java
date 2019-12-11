package com.briup.bean;

import java.util.List;

public class Tutor {
	private Integer tutorId; 
	private String name; 
	private String email; 
	private PhoneNumber phone;
	private Address address; 
	private List<Course> courses;
	
	public Tutor(){}
	public Tutor(String name, String email, 
			PhoneNumber phone,
			Address address) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	public Tutor(Integer tutorId, 
			String name, String email, 
			PhoneNumber phone,
			Address address) {
		super();
		this.tutorId = tutorId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	public Integer getTutorId() {
		return tutorId;
	}
	public void setTutorId(Integer tutorId) {
		this.tutorId = tutorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public PhoneNumber getPhone() {
		return phone;
	}
	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Tutor [tutorId=" + tutorId + ", name=" + name + ", email="
				+ email + ", phone=" + phone + ", address=" + address
				+ ", courses=" + courses + ", getTutorId()=" + getTutorId()
				+ ", getName()=" + getName() + ", getEmail()=" + getEmail()
				+ ", getPhone()=" + getPhone() + ", getAddress()="
				+ getAddress() + ", getCourses()=" + getCourses()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
