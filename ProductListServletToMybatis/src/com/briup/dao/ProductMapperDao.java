package com.briup.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.bean.Product;
import com.briup.dao.MyBatisSqlSessionFactory;
import com.briup.dao.ProductMapper;

public class ProductMapperDao {
	
	
	public void deleteProduct(String productName) {
		SqlSession  session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			//System.out.println(mapper);
			mapper.deleteProduct(productName);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addProduct(Product pro) {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			mapper.addProduct(pro);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateProduct(Product pro) {
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			mapper.updateProduct(pro);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Product GetProduct(String name) {
		SqlSession session = null;
		Product pro =null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			pro = mapper.GetProduct(name);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pro;
	}
	public static void main(String[] args) {
		//new ProductMapperDao().deleteProduct("金华火腿");
		Product pro = new Product("火鸡面", 2.28, "A");
		//new ProductMapperDao().addProduct(pro);
		//new ProductMapperDao().updateProduct(pro);
		//System.out.println(new ProductMapperDao().GetProduct("宽面").toString());
	}
}
