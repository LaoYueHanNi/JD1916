package com.briup.serviceImpl;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.bean.Customer;
import com.briup.common.MyBatisSqlSessionFactory;
import com.briup.dao.CustomerDao;
import com.briup.exception.CustomerException;
import com.briup.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {

	// 注册
	@Override
	public void register(Customer cus) throws CustomerException {
		SqlSession session = null;
		session = MyBatisSqlSessionFactory.openSession();
		CustomerDao mapper = session.getMapper(CustomerDao.class);
		try {
			if (mapper.selectCustomerByName(cus.getName()) != null) {
				throw new CustomerException("用户名已存在");
			}
			mapper.insertCustomer(cus);
			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomerException(e.getMessage());
		}finally {
			if(session!=null)session.close();
		}
	}

	// 登录
	@Override
	public Customer login(String name, String pwd) throws CustomerException {
		SqlSession session = null;
		Customer customer = new Customer();
		try {
			session = MyBatisSqlSessionFactory.openSession();
			CustomerDao mapper = session.getMapper(CustomerDao.class);
			customer = mapper.selectCustomerByName(name);
			System.out.println("id:"+customer.getCustomerId());
			if(customer==null||!customer.getPassword().equals(pwd)) {
				throw new CustomerException(" 用户名或密码错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomerException(e.getMessage());
		}
		return customer;
	}

	
	//通过名字寻找用户
	@Override
	public Customer findCustomerByName(String name) throws CustomerException {
		SqlSession session = null;
		Customer customer = new Customer();
		try {
			session = MyBatisSqlSessionFactory.openSession();
			CustomerDao mapper = session.getMapper(CustomerDao.class);
			customer = mapper.selectCustomerByName(name);
			if(customer==null) {
				throw new CustomerException(" 无此用户");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomerException(e.getMessage());
		}finally {
			if(session!=null)session.close();
		}
		return customer;
	}
}
