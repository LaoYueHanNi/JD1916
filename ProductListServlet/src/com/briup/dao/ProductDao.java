package com.briup.dao;

import com.briup.bean.Product;

public interface ProductDao {
	
	//删除产品
	public void deleteProduct(String productName);
	//添加产品
	public void addProduct(Product pro);
	//修改产品
	public void updateProduct(Product pro);
	//查询产品
	public Product GetProduct(String name);
	
}
