package com.pwc.controller;

public class Car {

	private String name;
	
	private Double price;
	
	private String category;


	public Car(String name, Double price, String category) {		
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	public Car(){
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}	
