package com.briup.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.briup.bean.Book;
import com.briup.bean.Category;
import com.briup.exception.BookException;

public interface CategoryDao {
	
	////�������еķ���(һ������)
	@Select("select * from es_category where parent_id is null")
	@ResultMap("com.briup.dao.CategoryDao.CategoryResult")
	List<Category> findAllCategory() throws BookException;
	
	@Select("select\r\n" + 
			"		e1.categoryId,e1.name,e1.description,e2.categoryId e2id,e2.name e2name,e2.description e2d\r\n" + 
			"		from es_category e1,es_category e2\r\n" + 
			"		where e1.categoryId=e2.parent_id\r\n" + 
			"		and\r\n" + 
			"		e1.parent_id is null")
	@ResultMap("com.briup.dao.CategoryDao.CategoryAndSonResult")
	List<Category> findAllCategoryWithSon() throws BookException;
	
	//����һ������ID���������ӷ���
	@Select("select * from es_category where parent_id=#{id}")
	@ResultMap("com.briup.dao.CategoryDao.CategoryResult")
	List<Category> findSubCategorys(int parentId) throws BookException;
	
	//���ݷ���ID���Ҵ˷���
	@Select("select * from es_category where categoryId=#{id}")
	@ResultMap("com.briup.dao.CategoryDao.CategoryAndSonResult")
	Category findCategoryById(int categoryId) throws BookException;
	
	
	List<Category> listCategory();

}
