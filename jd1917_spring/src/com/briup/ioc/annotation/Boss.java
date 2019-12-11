package com.briup.ioc.annotation;

import org.springframework.stereotype.Component;

//@Component代表是一个bean组件
@Component
public class Boss {
	private String name;
	
	private Car car;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
}
