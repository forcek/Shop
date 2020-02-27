package net.force.shopbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	
	//private fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@JsonIgnore
	private String description;
	
	@Column(name = "image_URL")
	private String imageURL;
	
	private double price;
	
	private int quantity;
	
	@Column(name = "is_active")
	private boolean active = true;
	
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", imageURL=" + imageURL
				+ ", price=" + price + ", active=" + active + "]";
	}
	
	
	

}
