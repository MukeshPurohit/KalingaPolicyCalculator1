package com.mindtree.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Scheme implements Comparable<Scheme> {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	@ManyToOne
	private Bank bank;
	@ManyToOne
	private ProductType productType;
	private int roi;
	
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
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public int getRoi() {
		return roi;
	}
	public void setRoi(int roi) {
		this.roi = roi;
	}
	@Override
	public String toString() {
		return "Scheme [id=" + id + ", name=" + name + ", bank=" + bank + ", productType=" + productType + ", roi="
				+ roi + "]";
	}
	public Scheme(int id, String name, Bank bank, ProductType productType, int roi) {
		super();
		this.id = id;
		this.name = name;
		this.bank = bank;
		this.productType = productType;
		this.roi = roi;
	}
	public Scheme() {
		super();
	}
	public int compareTo(Scheme s) {
		return s.getRoi() - getRoi();
	}
	
	
	
	
}
