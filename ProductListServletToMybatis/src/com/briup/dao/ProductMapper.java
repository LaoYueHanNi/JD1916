package com.briup.dao;

import com.briup.bean.Product;

public interface ProductMapper {
	
	//ɾ����Ʒ
	public void deleteProduct(String name);
	//��Ӳ�Ʒ
	public void addProduct(Product pro);
	//�޸Ĳ�Ʒ
	public void updateProduct(Product pro);
	//��ѯ��Ʒ
	public Product GetProduct(String name);
	
}
