package com.onlineshop.service;

import java.util.List;

import com.onlineshop.entity.EmployeeEntity;
import com.onlineshop.entity.EntityProduct;


public interface EmployeeService {

	
//	EmployeeEntity saveUser(EmployeeEntity employeeEntity) ;
	List<EmployeeEntity> getAllEmployee();
	public Long getCount();
	
	EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) ;
	
	EmployeeEntity getEmployeeById(int employeeId);
	EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);
	
	void deleteEmployee(int id);
	
}
