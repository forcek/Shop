package net.force.shopbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;

	@Column(name = "address_line_1")
	private String addressLineNo1;

	@Column(name = "address_line_2")
	private String addressLineNo2;
	
	private String state;
	
	private String city;
	
	private String country;
	
	private String pincode;
	
	private boolean shipping;
	
	private boolean billing;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getAddressLineNo1() {
		return addressLineNo1;
	}

	public void setAddressLineNo1(String addressLineNo1) {
		this.addressLineNo1 = addressLineNo1;
	}

	public String getAddressLineNo2() {
		return addressLineNo2;
	}

	public void setAddressLineNo2(String addressLineNo2) {
		this.addressLineNo2 = addressLineNo2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public boolean isShipping() {
		return shipping;
	}

	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}

	public boolean isBilling() {
		return billing;
	}

	public void setBilling(boolean billing) {
		this.billing = billing;
	}

	
	
	@ManyToOne
	private User user;
		
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", addressLineNo1=" + addressLineNo1 + ", addressLineNo2="
				+ addressLineNo2 + ", state=" + state + ", city=" + city + ", country=" + country + ", pincode="
				+ pincode + ", shipping=" + shipping + ", billing=" + billing + "]";
	}

	
	
	
	

}
