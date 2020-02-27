package net.force.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.force.shopbackend.dao.ProductDAO;
import net.force.shopbackend.dto.Product;

@Controller
@RequestMapping("json/data")
public class JsonDataController {

	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping("/buy/products")
	@ResponseBody
	public List<Product> showProduct(){
		
		return productDAO.listActiveProducts();
		
	}
	
	
}
