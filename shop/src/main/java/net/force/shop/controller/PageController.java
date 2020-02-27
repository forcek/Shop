package net.force.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.force.shop.exception.ProductNotFoundException;
import net.force.shopbackend.dao.ProductDAO;
import net.force.shopbackend.dto.Product;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = { "/", "home", "index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
	//	mv.addObject("products", ProductDAO.list());
		
		mv.addObject("userClickHome", true);

		return mv;

	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);

		return mv;

	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);

		return mv;

	}

	@RequestMapping(value = "/buy/products")
	public ModelAndView buyProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Buy Products");
		
		mv.addObject("products", productDAO.list());
		
		mv.addObject("userClickBuyProducts", true);

		return mv;

	}
	
	
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView viewProduct(@PathVariable int id) throws ProductNotFoundException {
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		mv.addObject("title",product.getName());
		mv.addObject("product", product);
		
		mv.addObject("userClickViewProduct", true);
		
		
		return mv;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
