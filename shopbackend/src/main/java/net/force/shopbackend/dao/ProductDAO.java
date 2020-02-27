package net.force.shopbackend.dao;

import java.util.List;

import net.force.shopbackend.dto.Product;

public interface ProductDAO {

	 Product get(int id); 
	 List<Product> list();
	 boolean add(Product product);
	 boolean update(Product product);
	 boolean delete(Product product);

	 List<Product> listActiveProducts();
	 
}

