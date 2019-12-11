package com.briup.service;

import com.briup.bean.Product;
import com.briup.dao.ProductDao;
import com.briup.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
	private ProductDao  proDao;
	
	public ProductServiceImpl() {
		proDao = new ProductDaoImpl();
	}
	@Override
	public boolean delete(String name) {
		if(proDao.GetProduct(name).getName()!=null) {
			proDao.deleteProduct(name);
			return true;
		}else {
			return false;
		}
	}
                                        
	@Override
	public boolean add(Product pro) {
		if(proDao.GetProduct(pro.getName()).getName()!=null) {
			return false;
		}else {
			proDao.addProduct(pro);
			return true;
		}
	}

	@Override
	public boolean update(Product pro) {
		if(proDao.GetProduct(pro.getName()).getName()!=null) {
			proDao.updateProduct(pro);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Product Get(String name) {
		Product pro = new Product();
		pro=proDao.GetProduct(name);
		if(pro.getName()!=null) {
			return pro;
		}else {
			return null;
		}
	}

}
