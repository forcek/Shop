package net.force.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.force.shop.util.FileUploadUtility;
import net.force.shop.validator.ProductValidator;
import net.force.shopbackend.dao.ProductDAO;
import net.force.shopbackend.dto.Product;

@Controller
@RequestMapping(value = "/manage")
public class ManagementController {

	@Autowired
	private ProductDAO productDAO;

	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProducts", true);

		mv.addObject("title", "Manage Products");

		Product np = new Product();
		np.setActive(true);

		mv.addObject("product", np);

		if (operation != null) {

			if (operation.equals("product")) {
				mv.addObject("message", "Product added Successfull!");
			}

		}

		return mv;
	}
	
	
	@RequestMapping(value ="/{id}/product", method = RequestMethod.GET)
	public ModelAndView showEditProducts(@PathVariable int id) {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProducts", true);

		mv.addObject("title", "Manage Products");

		Product np = productDAO.get(id);

		mv.addObject("product", np);

		return mv;
	}
	
	
	
	
// Product submission
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mp, BindingResult results,
			Model model, HttpServletRequest request) {

		
		if(mp.getId() == 0){
			
			new ProductValidator().validate(mp, results);
		}
		else {
			if(!mp.getFile().getOriginalFilename().equals("")){
				new ProductValidator().validate(mp, results);
				
			}
		}
		
		 if (results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);

			model.addAttribute("title", "Manage Products");
			model.addAttribute("message1", "Validation for Product Submission failed!");

			return "page";
		}

		logger.info(mp.toString());

		if(mp.getId() == 0){
			productDAO.add(mp);
		}
		else {
			productDAO.update(mp);
		}

		if (!mp.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mp.getFile(), mp.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	
	@RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id){
		
		Product product = productDAO.get(id); //to get data from data base
		
		boolean isActive = product.isActive();
		
		product.setActive(!product.isActive()); //changing active state using !(not)
		
		productDAO.update(product);
		return (isActive)?"You have successfully deactivated the product with id "+product.getId()
						:"You have successfully activated the product with id "+product.getId();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
