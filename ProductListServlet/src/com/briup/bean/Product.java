package com.briup.bean;

public class Product {
	private String name;
	private double price;
	private String productor;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductor() {
		return productor;
	}
	public void setProductor(String productor) {
		this.productor = productor;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", productor=" + productor + "]";
	}
	
}
