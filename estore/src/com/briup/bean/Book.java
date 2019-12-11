package com.briup.bean;

import java.util.Date;

public class Book {
	private int bookId;
	private String name;
	private double price;
	private String author;
	private String publisher;
	private Date pubDate;
	private String description;
	private Category category;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Book() {
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", price=" + price + ", author=" + author + ", publisher="
				+ publisher + ", pubDate=" + pubDate + ", description=" + description + ", category=" + category + "]";
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
