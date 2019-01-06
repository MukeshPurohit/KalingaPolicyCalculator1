package com.mindtree.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bank {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	
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
	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + "]";
	}
	public Bank(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Bank() {
		super();
	}
	
	
}
