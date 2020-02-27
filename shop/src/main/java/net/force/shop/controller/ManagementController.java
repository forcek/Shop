package net.force.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.force.shopbackend.dto.Product;

@Controller
@RequestMapping(value = "/manage")
public class ManagementController {

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts() {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProducts", true);

		mv.addObject("title", "Manage Products");

		Product np = new Product();
		np.setActive(true);
		
		mv.addObject("product", np);
		
		return mv;
	}

}
