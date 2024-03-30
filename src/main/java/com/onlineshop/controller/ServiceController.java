package com.onlineshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.onlineshop.entity.EntityCategory;
import com.onlineshop.entity.EntityProduct;

@Controller
public class ServiceController {
	
	@GetMapping("/service")
	public String servicePage() {
		return "serviceTemplates/servicepage";
				
	}
	
	
	
	// this method will create empty object and open the form addcategory and that form will return url of below method ie /category
//			@GetMapping("/addservice")
//			public String product(Model model) {
//				ServiceEntity entityProduct = new EntityService();
//				model.addAttribute("entityProduct",entityProduct);
//				List<EntityCategory> listCategory = categoryRepository.findAll();
//				model.addAttribute("listCategory",listCategory);
//				System.out.println(entityProduct);
//				return "productTemplates/addProduct";
//			}
}
