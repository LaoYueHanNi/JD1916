package com.briup.ioc.annotation;

import org.springframework.stereotype.Component;

@Component
public class Car {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
