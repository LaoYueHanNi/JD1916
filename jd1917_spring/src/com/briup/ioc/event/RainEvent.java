package com.briup.ioc.event;

import org.springframework.context.ApplicationEvent;

//ʱ�����
public class RainEvent extends ApplicationEvent{
	
	public RainEvent(Object source) {
		super(source);
	}
}
