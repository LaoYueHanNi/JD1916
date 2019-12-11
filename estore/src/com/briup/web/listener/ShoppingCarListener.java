package com.briup.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.briup.bean.ShoppingCar;

@WebListener
public class ShoppingCarListener implements HttpSessionListener {

    public ShoppingCarListener() {
    }


    public void sessionCreated(HttpSessionEvent se)  { 
    	ShoppingCar shoppingCar = new ShoppingCar();
    	se.getSession().setAttribute("shoppingCar", shoppingCar);
    }


    public void sessionDestroyed(HttpSessionEvent se)  { 
    }
	
}
