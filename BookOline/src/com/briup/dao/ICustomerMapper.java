package com.briup.dao;

import com.briup.bean.Customer;

public interface ICustomerMapper {
	public void addCustomer(Customer customer);
	public Customer findCustomerByName(String name);
	public Customer findCustomerByNameWithPassword(String username,String password);
	public void updateCustomer(Customer customer);
}
