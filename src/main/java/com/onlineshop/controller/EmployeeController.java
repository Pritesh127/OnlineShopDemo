package com.onlineshop.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.onlineshop.entity.EmployeeEntity;

import com.onlineshop.service.EmployeeService;


@Controller
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	
	@GetMapping("/employee")
	public String employee(Model model) {
		model.addAttribute("employeeEntity", employeeService.getAllEmployee());
		return "employeeTemplate/employeepage";
	}
	
	@GetMapping("/addemployee")
	public String product(Model model) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		model.addAttribute("employeeEntity",employeeEntity);
//		List<EntityCategory> listCategory = categoryRepository.findAll();
//		model.addAttribute("listCategory",listCategory);
		System.out.println(employeeEntity);
		return "employeeTemplate/addemployee";
	}
	
	
	@PostMapping("/employee")
	public String addEmployee(@ModelAttribute("employeeEntity") EmployeeEntity employeeEntity) {
		System.out.println("inside add category method ***************");
		System.out.println(employeeEntity);
//		entityProduct.setManufacturingDate(new Date());
		
		employeeService.saveEmployee(employeeEntity);
		
//		return "categoryTemplate/categorypage";
		return "redirect:/employee";
	}
	
	
	// for updating we need to fetch category data from database so we create method in service to get data from id
	//	and than use that method in below method 
	@GetMapping("/employee/edit/{id}")
	public String editProduct(@PathVariable int id, Model model) {
		System.out.println("inside edit method +**************");
//		int i=Integer.parseInt(id);  
//		List<EntityCategory> listCategory = categoryRepository.findAll();
//		model.addAttribute("listCategory",listCategory);
		System.out.println(id);
		model.addAttribute("employeeEntity", employeeService.getEmployeeById(id));
		return "employeeTemplate/editemployee";
	}
	
	
	@PostMapping("/employee/{id}")
	public String updateEmployee(@PathVariable int id,
			@ModelAttribute("employeeEntity") EmployeeEntity employeeEntity,
			Model model) {
		System.out.println("-7+++++++7********+*47-*4-+7*-+7-+74=======================*");
		
		// get category form database by id
		EmployeeEntity employee = employeeService.getEmployeeById(id);
		System.out.println(" before product setting  method ***********************");
		employee.setEmployeeFirstName(employeeEntity.getEmployeeFirstName());
		employee.setEmployeeLastName(employeeEntity.getEmployeeLastName());
//		product.setManufacturingDate(entityProduct.getManufacturingDate());
		employee.setEmployeeMobile(employeeEntity.getEmployeeMobile());
		
		System.out.println(" before save method ***********************");
		//save updated category
		employeeService.updateEmployee(employee);
		return "redirect:/employee";
	}
	
	@GetMapping("/deleteemployee/{id}")
	public String deleteproduct(@PathVariable int id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employee";
	}
	
	
}
