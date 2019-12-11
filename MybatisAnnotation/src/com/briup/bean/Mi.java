package com.briup.bean;

public class Mi {
	private int miId;
	private String name;
	private String points;
	
	public Mi() {
	}

	public Mi(int miId, String name, String points) {
		super();
		this.miId = miId;
		this.name = name;
		this.points = points;
	}

	public int getMiId() {
		return miId;
	}

	public void setMiId(int miId) {
		this.miId = miId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Mi [miId=" + miId + ", name=" + name + ", points=" + points + "]";
	}

}
