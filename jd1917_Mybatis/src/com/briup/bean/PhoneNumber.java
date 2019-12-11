package com.briup.bean;

public class PhoneNumber {

	private String countryCode; 
	private String stateCode; 
	private String number; 
	public PhoneNumber() {}
	
	public PhoneNumber(String phone) {
		if(phone!=null) {
			String str[] = phone.split("-");
			this.countryCode = str[0];
			this.stateCode = str[1];
			this.number = str[2];
		}
		
	}
	
	public PhoneNumber(String countryCode, String stateCode, String number) {
		super();
		this.countryCode = countryCode;
		this.stateCode = stateCode;
		this.number = number;
	}
	
	@Override
	public String toString() {
		return countryCode+"-"+stateCode+"-"+number;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}
