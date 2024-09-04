package com.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private String autherName;
	private double price;

//	no arg constructor
	public Book() {
		super();
	}
// arg constructor
	public Book(long id, String title, String autherName, double price) {
		super();
		this.id = id;
		this.title = title;
		this.autherName = autherName;
		this.price = price;
	}

	
//   Setter and Getter Method	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAutherName() {
		return autherName;
	}

	public void setAutherName(String autherName) {
		this.autherName = autherName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

//	 to string method
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", autherName=" + autherName + ", price=" + price + "]";
	}
	
	

}
