package com.briup.ioc.event;

import org.springframework.context.ApplicationEvent;

//时间对象
public class RainEvent extends ApplicationEvent{
	
	public RainEvent(Object source) {
		super(source);
	}
}
