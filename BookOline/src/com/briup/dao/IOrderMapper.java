package com.briup.dao;

import java.util.List;

import com.briup.bean.Order;


public interface IOrderMapper {
	public void addOrder(Order order);
	public List<Order> findOrdersByCustomerId(Long id);
	public void removeOrder(Long id);
	public Order findOrderBy(Long id);
}
