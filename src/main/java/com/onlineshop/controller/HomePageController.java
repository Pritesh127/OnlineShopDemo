package com.onlineshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlineshop.service.EmployeeService;
import com.onlineshop.service.UserService;

@Controller
@RequestMapping("/")
public class HomePageController {
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public EmployeeService employeeService;
	
	@GetMapping("/")
	public String landlingPage() {
		
		return "landingPageTemplate/index";
	}
	
	@GetMapping("/homepage")
	public String landingPage(Model model) {
		 Long totalUser =  userService.getCount();
		 Long totalEmployee =  employeeService.getCount();
		 System.out.println(totalUser);
		 System.out.println("******************************************************");
		 List<Long> users=new ArrayList<Long>();
		 
		 List<Long> employeeCount=new ArrayList<Long>();
		 employeeCount.add(totalEmployee);
		 users.add(totalUser);
		 model.addAttribute("userCount", users);
		 model.addAttribute("employeeCount", totalEmployee);
		return "homeTemplate/landingpage";
	}
	
	
	

}
