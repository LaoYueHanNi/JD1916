package com.briup.service;

import com.briup.bean.Product;

public interface ProductService {
	public boolean delete(String productName);
	public boolean add(Product pro);
	public boolean update(Product pro);
	public Product Get(String name);
}
