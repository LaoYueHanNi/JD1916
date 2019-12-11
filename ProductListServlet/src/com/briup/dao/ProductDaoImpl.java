package com.briup.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.briup.bean.Product;

public class ProductDaoImpl implements ProductDao {
	private Connection conn;

	@SuppressWarnings("static-access")
	public ProductDaoImpl() {
		conn = new ConnectionFactory().getConnection();
	}

	@Override
	public void deleteProduct(String productName) {
		try {
			Statement statement = conn.createStatement();
			String sql = "delete from e_product where name='" + productName + "'";
			statement.execute(sql);
			System.out.println("É¾³ý³É¹¦");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("É¾³ýÊ§°Ü");
			e.printStackTrace();
		}
	}

	@Override
	public void addProduct(Product pro) {
		try {
			Statement statement = conn.createStatement();
			String sql = "insert into e_product values(pro_seq.nextVal,'" + pro.getName() + "'," + pro.getPrice() + ",'"
					+ pro.getProductor() + "')";
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateProduct(Product pro) {
		try {
			Statement statement = conn.createStatement();
			String sql = "update e_product set price=" 
					+ pro.getPrice() + ",productor='" 
					+ pro.getProductor()
					+ ",' where name='" + pro.getName() + "'";
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Product GetProduct(String name) {
		Product pro = new Product();
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from e_product where name='" + name + "'";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				pro.setId(rs.getInt(1));
				pro.setName(rs.getString(2));
				pro.setPrice(rs.getDouble(3));
				pro.setProductor(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pro;
	}

}
