package com.briup.service;

import com.briup.bean.Product;
import com.briup.dao.ProductMapperDao;

public class ProductServiceImpl implements ProductService{
	
	private ProductMapperDao pmd;
	public ProductServiceImpl() {
		pmd = new ProductMapperDao();
	}
	
	@Override
	public boolean delete(String productName){
		
			if(pmd.GetProduct(productName)!=null) {
				pmd.deleteProduct(productName);
				return true;
			}
			return false;
	}

	@Override
	public boolean add(Product pro) {
		if(pmd.GetProduct(pro.getName())!=null) {
			return false;
		}else {
			pmd.addProduct(pro);
			return true;
		}
	}

	@Override
	public boolean update(Product pro) {
		if(pmd.GetProduct(pro.getName())!=null){
			pmd.updateProduct(pro);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Product Get(String name) {
		Product pro = new Product();
		pro=pmd.GetProduct(name);
		if(pro!=null) {
			return pro;
		}else {
			return null;
		}
	}

	public static void main(String[] args) {
		//System.out.println(new ProductServiceImpl().Get("øÌ√Ê"));
		new ProductServiceImpl().update(new Product("≈©∑Ú…Ω", 12.0, "A"));
	}
}
