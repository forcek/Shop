package net.force.shopbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	
	//private fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Please enter the Product Name!")
	private String name;
	
	private String code;
	
	@JsonIgnore
	@NotBlank(message = "Please enter the Description for the product!")
	private String description;
	
	@Column(name = "image_URL")
	private String imageURL;
	
	@Min(value=1, message="Price should be more than 1!")
	private int price;
	
	private int quantity;
	
	@Column(name = "is_active")
	private boolean active = true;
	
	
	/*
	 * Generating random code for product for images to store in the database.
	 * */
	public Product(){
		this.code = "PRD" + UUID.randomUUID().toString().substring(25).toUpperCase();
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public int getPrice() {
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
		return "Product [id=" + id + ", name=" + name + ", code=" + code + ", description=" + description
				+ ", imageURL=" + imageURL + ", price=" + price + ", quantity=" + quantity + ", active=" + active + "]";
	}
	
	
	

}
