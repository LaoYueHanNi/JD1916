package com.briup.bean;

import java.util.Date;

import org.apache.ibatis.type.Alias;

//��students�����
//@Alias("Student")		ע��: @Alias Ҫ��<package name=""/>��ǩ���ʹ��,Mybatis���Զ��鿴ָ�����ڵ������ע��,���û�����ע��,��ôĬ�ϵı��������������

public class Student {
	private Integer id;/// stud_id
	private String name; /// name
	private String email; // email
	private Date dob; // dob
	private PhoneNumber phone;
	private Address address;

	public Student(Integer id, String name, String email, Date dob, PhoneNumber phone, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phone = phone;
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Student() {
	}

	public Student(Integer id, String name, String email, Date dob) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}

	public Student(Integer id, String name, String email, Date dob, PhoneNumber phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phone = phone;
	}
	
	public Student( String name, String email, Date dob, PhoneNumber phone) {
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phone = phone;
	}
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public PhoneNumber getPhone() {
		return phone;
	}

	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", phone=" + phone
				+ ", address=" + address + "]";
	}
}
