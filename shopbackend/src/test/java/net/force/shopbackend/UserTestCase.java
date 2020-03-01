package net.force.shopbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.force.shopbackend.dao.UserDAO;
import net.force.shopbackend.dto.Address;
import net.force.shopbackend.dto.Cart;
import net.force.shopbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static UserDAO userDAO;
	
	private User user = null;
	
	private Address address = null;
	
	private Cart cart = null;
	
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		
		context.scan("net.force.shopbackend");
		context.refresh();
		
		userDAO = (UserDAO)context.getBean("userDAO");
		
	}
	
/*	
	@Test
	public void addUser(){
		
		user = new User();
		user.setFirstName("Abuasim");
		user.setLastName("Khan");
		user.setEmail("kabu@gmail.com");
		user.setPassword("user123");
		user.setContactNumber("7845693210");
		user.setRole("USER");
		
		assertEquals("Failed to add user!", true,userDAO.add(user));
		
		
		address = new Address();
		address.setAddressLineNo1("A-204, Nachiket APT");
		address.setAddressLineNo2("Manickpur Chulna Road");
		address.setCity("Vasai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPincode("401202");
		address.setBilling(true);
		
		address.setUserId(user.getId());
		
		assertEquals("Failed to add billing address!", true,userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")){
			
			cart = new Cart();
			cart.setUser(user);
			
			assertEquals("Failed to add cart!", true,userDAO.addCart(cart));
			
			address = new Address();
			address.setAddressLineNo1("A-204, Nachiket APT");
			address.setAddressLineNo2("Manickpur Chulna Road");
			address.setCity("Vasai");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPincode("401202");
			address.setShipping(true);
			
			address.setUserId(user.getId());
			
			assertEquals("Failed to add shippng address", true, userDAO.addAddress(address));
		}
		
	}
	
*/	
	
	
/*	
	@Test
	public void addUser(){
		
		user = new User();
		user.setFirstName("Abuasim");
		user.setLastName("Khan");
		user.setEmail("kabu@gmail.com");
		user.setPassword("user123");
		user.setContactNumber("7845693210");
		user.setRole("USER");
		
	
		if(user.getRole().equals("USER")){
			
			cart = new Cart();
			cart.setUser(user);
		
			user.setCart(cart);
		}
	
		assertEquals("Failed to add user!", true,userDAO.addUser(user));
		
	}
	*/
/*
	@Test
	public void testUpdateCart(){
		
		user = userDAO.getByEmail("kabu@gmail.com");
		
		cart = user.getCart();
		
		cart.setGrandTotal(10000);
		
		cart.setCartLines(2);
	
		assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));
	}
	
	
	*/
	
	/*
	@Test
	public void testAddAddress(){
		
		user = new User();
		user.setFirstName("Abuasim");
		user.setLastName("Khan");
		user.setEmail("kabu@gmail.com");
		user.setPassword("user123");
		user.setContactNumber("7845693210");
		user.setRole("USER");
		
		assertEquals("Failed to add user!", true,userDAO.addUser(user));
		
		address = new Address();
		address.setAddressLineNo1("A-204, Nachiket APT");
		address.setAddressLineNo2("Manickpur Chulna Road");
		address.setCity("Vasai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPincode("401202");
		address.setBilling(true);
		
		address.setUser(user);
		
		assertEquals("Failed to add billing address!", true,userDAO.addAddress(address));
		
		address = new Address();
		address.setAddressLineNo1("A-204, Nachiket APT");
		address.setAddressLineNo2("Manickpur Chulna Road");
		address.setCity("Vasai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPincode("401202");
		address.setShipping(true);
		
		address.setUser(user);
		
		assertEquals("Failed to add shippng address", true, userDAO.addAddress(address));
	
		
	}
*/	
	/*
	@Test
	public void testAddAddress(){
		
		user = userDAO.getByEmail("kabu@gmail.com");
		
		address = new Address();
		address.setAddressLineNo1("Shop No. 2 Vitthal Dham");
		address.setAddressLineNo2("Manickpur Chulna Road");
		address.setCity("Vasai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPincode("401202");
		address.setShipping(true);
		
		address.setUser(user);
		
		assertEquals("Failed to add shippng address", true, userDAO.addAddress(address));
	
		
	}
	
	*/
	
	@Test
	public void testGetListOfAddresses(){
		
		user = userDAO.getByEmail("kabu@gmail.com");
		
		
		assertEquals("Failed to fetch shipping address!", 2, userDAO.listShippingAddress(user).size());

		assertEquals("Failed to fetch shipping address!", "Maharashtra", userDAO.getBillingAddress(user).getState());
	}
	
	
	
	
	
	
	
	
}
