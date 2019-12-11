package com.briup.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Order;
import com.briup.bean.OrderLine;
import com.briup.common.MyBatisSqlSessionFactory;
import com.briup.dao.OrderDao;
import com.briup.dao.OrderLineDao;
import com.briup.service.IOrderService;

public class OrderServiceImpl implements IOrderService{

	@Override
	public void saveOrder(Order order) {
		SqlSession session=MyBatisSqlSessionFactory.openSession();
		OrderDao dao1=session.getMapper(OrderDao.class);
		OrderLineDao dao2=session.getMapper(OrderLineDao.class);
		dao1.addOrder(order);//保存订单
		for(OrderLine line:order.getOrderLines()){
			dao2.addOrderLine(line);
		}
		session.commit();
	}

	@Override
	public Order findOrderByCustomerId(int customerId) {
		SqlSession session=MyBatisSqlSessionFactory.openSession();
		OrderDao dao=session.getMapper(OrderDao.class);
		OrderLineDao dao2=session.getMapper(OrderLineDao.class);
		List<Order> order = dao.selectOrder(customerId);
		for(Order o:order) {
			dao.addOrder(o);//保存订单
			for(OrderLine line:o.getOrderLines()){
				dao2.addOrderLine(line);
			}
		}
		session.commit();
		return null;
	}
}
