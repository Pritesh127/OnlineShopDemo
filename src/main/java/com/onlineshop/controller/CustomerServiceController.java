package com.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerServiceController {

	
	@GetMapping("/addservice")
	public String addService() {
		return "serviceTemplates/addService";
	}
}
