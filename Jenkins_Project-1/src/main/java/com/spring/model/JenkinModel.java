package com.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class JenkinModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String Name;
	private String Address;
	private long mobileNo;
	
	
//	arg constructor
	public JenkinModel(long id, String name, String address, long mobileNo) {
		super();
		this.id = id;
		Name = name;
		Address = address;
		this.mobileNo = mobileNo;
	}
	
//	no arg constructor
	public JenkinModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	Setter and getter method
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
	
	@Override
	public String toString() {
		return "JenkinModel [id=" + id + ", Name=" + Name + ", Address=" + Address + ", mobileNo=" + mobileNo + "]";
	}
	

}
