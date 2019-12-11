package com.briup.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.briup.bean.Customer;

//和顾客表相关的映射接口
public interface CustomerDao {

	@Insert("insert into es_customer values(#{customerId},#{name},#{password},#{zipCode},#{address},#{telephone},#{email})")
	@SelectKey(statement = "SELECT es_customer_id.NEXTVAL FROM DUAL", keyProperty = "customerId", resultType = int.class, before = true)
	int insertCustomer(Customer customer) throws Exception;
	
	@Select("select * from es_customer where customerId=#{id}")
	Customer selectCustomerById(int id) throws Exception;
	
	@Select("select * from es_customer where name=#{name}")
	Customer selectCustomerByName(String name) throws Exception;
}
