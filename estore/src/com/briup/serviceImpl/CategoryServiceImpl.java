package com.briup.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Category;
import com.briup.common.MyBatisSqlSessionFactory;
import com.briup.dao.CategoryDao;
import com.briup.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService{

	@Override
	public List<Category> getCategory() {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		CategoryDao dao = session.getMapper(CategoryDao.class);
		return dao.listCategory();
	}

}
