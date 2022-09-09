package com.example.demo.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long item_id;
	String item_name;
	Double quantity;
	Double price;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(long item_id, String item_name, Double quantity, Double price) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.quantity = quantity;
		this.price = price;
	}
	public long getItem_id() {
		return item_id;
	}
	public void setItem_id(long item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", item_name=" + item_name + ", quantity=" + quantity + ", price=" + price
				+ "]";
	}
	
	
}
