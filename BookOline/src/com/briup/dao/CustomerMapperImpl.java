package com.briup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.briup.bean.Customer;
import com.briup.common.util.ConnectionFactory;

public class CustomerMapperImpl implements ICustomerMapper {

	private Connection conn;

	public CustomerMapperImpl() {
		conn = new ConnectionFactory().getConnection();
	}

	@Override
	public void addCustomer(Customer customer) {
		try {
			Statement statement = conn.createStatement();
			String sql = "insert into tbl_customer values(tbl_customer_seq.nextVal" + ",'" + customer.getName() + "','"
					+ customer.getPassword() + "','" + customer.getZip() + "','" + customer.getAddress() + "','"
					+ customer.getTelephone() + "','" + customer.getEmail() + "')";
			statement.execute(sql);

//			String sql = "insert into tbl_customer values(tbl_customer_seq.nextVal,?,?,?,?,?,?) ";
//			PreparedStatement pst = conn.prepareStatement(sql);
//			pst.setString(1, customer.getName());
//			pst.setString(2, customer.getPassword());
//			pst.setString(3, customer.getZip());
//			pst.setString(4, customer.getAddress());
//			pst.setString(5, customer.getTelephone());
//			pst.setString(6, customer.getEmail());
//			pst.execute(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("null")
	@Override
	public Customer findCustomerByName(String name) {
		Customer c = new Customer();
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from tbl_customer where name='" + name + "'";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				c.setId((long) rs.getInt(1));
				c.setName(rs.getString(2));
				c.setPassword(rs.getString(3));
				c.setZip(rs.getString(4));
				c.setTelephone(rs.getString(5));
				c.setAddress(rs.getString(6));
				c.setEmail(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Customer findCustomerByNameWithPassword(String username, String password) {
		Customer c = new Customer();
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from tbl_customer where name='" + username + "' and password='" + password + "'";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				c.setId((long) rs.getInt(1));
				c.setName(rs.getString(2));
				c.setPassword(rs.getString(3));
				c.setZip(rs.getString(4));
				c.setTelephone(rs.getString(5));
				c.setAddress(rs.getString(6));
				c.setEmail(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public void updateCustomer(Customer customer) {
		try {
			Statement statement = conn.createStatement();
			String sql = "update tbl_customer set name='"+customer.getName()+"',password='"
					+customer.getPassword()+"',zip='"+customer.getZip()+"',address='"+
					customer.getAddress()+"',telephone='"+customer.getTelephone()+"',email='"
					+customer.getEmail()+"' where id ="+customer.getId();
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Customer c = new Customer((long) 2, "xiha", "xixxi", "niz", "dd", "123",
		 "34219@qq.com",null);
		CustomerMapperImpl cmi = new CustomerMapperImpl();
		// System.out.println(cmi.findCustomerByName("xiha").getName());
		// System.out.println(cmi.findCustomerByNameWithPassword("xiha",
		// "xi").getName());
		//cmi.updateCustomer(c);
	}
}
