package com.briup.service;

import com.briup.bean.Order;

public interface IOrderService {
	public void saveOrder(Order order);
	
	public Order findOrderByCustomerId(int customerId);
}
