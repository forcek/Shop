package net.force.shopbackend.dao;

import java.util.List;

import net.force.shopbackend.dto.Address;
import net.force.shopbackend.dto.Cart;
import net.force.shopbackend.dto.User;


public interface UserDAO {
	
	boolean addUser(User user);
	
	boolean addAddress(Address address);
	
	Address getBillingAddress(User user);//alternative using of userId
	List<Address> listShippingAddress(User user);

	boolean updateCart (Cart cart);
	
	User getByEmail(String email);
	
	
}
