package com.briup.bean;

import java.io.Serializable;

/**
 * 订单�?
 * */
public class Line implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer num;
	/**
	 * 关联关系 -- 多对�?  对应�?个订�?
	 * */
	private Order order;
	/**
	 * 关联关系 -- 多对�?  对应�?类书
	 * */
	private Book book;
	
	public Line(){
		
	}
	public Line(Long id, Integer num) {
		this.id = id;
		this.num = num;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
}
