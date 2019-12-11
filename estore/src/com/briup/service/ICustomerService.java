package com.briup.service;

import com.briup.bean.Customer;
import com.briup.exception.CustomerException;

public interface ICustomerService {
	
	//ע��
	public void register(Customer cus) throws CustomerException;
	//��¼
	public Customer login(String name,String pwd) throws CustomerException;
	
	public Customer findCustomerByName(String name) throws CustomerException;
}
