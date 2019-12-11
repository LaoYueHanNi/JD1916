package com.briup.ioc.event;

import org.springframework.context.ApplicationListener;

public class Listener2 implements ApplicationListener<RainEvent>{

	@Override
	public void onApplicationEvent(RainEvent arg0) {
		System.out.println(arg0.getSource()+"打雷了,我要挖地了");
	}

}
