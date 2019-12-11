package com.briup.bean;

public class Product {
	private int id;
	private String name;
	private double price;
	private String productor;

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
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", productor=" + productor + "]";
	}

	public Product(int id, String name, double price, String productor) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.productor = productor;
	}

	public Product(String name, double price, String productor) {
		super();
		this.name = name;
		this.price = price;
		this.productor = productor;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

}
