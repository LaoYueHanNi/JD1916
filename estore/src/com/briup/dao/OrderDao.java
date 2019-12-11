package com.briup.dao;

import java.util.List;

import com.briup.bean.Order;

public interface OrderDao {
	public void addOrder(Order order);
	
	public List<Order> selectOrder(int customerId);
}
