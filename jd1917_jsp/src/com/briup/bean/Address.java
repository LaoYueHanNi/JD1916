package com.briup.bean;

public class Address {
	private String country;
	private String street;

	public Address(String country, String street) {
		this.country = country;
		this.street = street;
	}

	public Address() {
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
}