package net.force.shop.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.force.shopbackend.dao.ProductDAO;
import net.force.shopbackend.dto.Product;

@Controller
@RequestMapping(value = "/manage")
public class ManagementController {

	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation) {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProducts", true);

		mv.addObject("title", "Manage Products");

		Product np = new Product();
		np.setActive(true);

		mv.addObject("product", np);


		if(operation != null){
		
			if(operation.equals("product")){
				mv.addObject("message", "Product added Successfull!");
			}
			
		}
		
		return mv;
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mp, BindingResult results, Model model) {

		if(results.hasErrors()){
			model.addAttribute("userClickManageProducts", true);

			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation for Product Submission failed!");
			
			return "page";
		}
		
		logger.info(mp.toString());
		
		productDAO.add(mp);
		
		
		return "redirect:/manage/products?operation=product";
	}

}
