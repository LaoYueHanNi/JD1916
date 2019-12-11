package com.briup.web.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.briup.bean.Category;
import com.briup.service.ICategoryService;
import com.briup.serviceImpl.CategoryServiceImpl;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

    public ApplicationListener() {
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	ICategoryService service = new CategoryServiceImpl();
    	List<Category> list = service.getCategory();
    	for( Category c :list) {
			System.out.println(c);
		}
    	sce.getServletContext().setAttribute("category", list);
    }
	
}
