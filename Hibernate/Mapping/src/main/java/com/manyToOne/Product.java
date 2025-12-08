package com.manyToOne;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.oneToMany.Accounts;

@Entity
public class Product {
	
	@Id
	private int id;
	private String name;
	private double price;
	
	public Product() {
		super();
	}
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
	
	
}



//@OneToMany
//private List<Review> review;
//
//public List<Review> getReview() {
//	return review;
//}
//public void setReview(List<Review> review) {
//	this.review = review;
//}
