package com.briup.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

//²âÊÔServletRequestµÄ¼àÌýÆ÷
public class RequestListenerTest implements ServletRequestListener, ServletContextAttributeListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request destroy");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		ServletRequest req = sre.getServletRequest();
		System.out.println("request init");
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent scab) {
		System.out.println("add ");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println("rem");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println("repla ");
	}
}
