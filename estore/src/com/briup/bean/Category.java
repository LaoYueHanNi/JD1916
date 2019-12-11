package com.briup.bean;

import java.util.List;

public class Category {
	private int categoryId;
	private String name;
	private String description;
	private List<Category> categorys;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Category> getCategorys() {
		return categorys;
	}
	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + ", description=" + description + ", categorys="
				+ categorys + "]";
	}
	public Category(int categoryId, String name, String description, List<Category> categorys) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.categorys = categorys;
	}
	public Category() {
	}
}
