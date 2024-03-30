package com.onlineshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshop.entity.EmployeeEntity;

import com.onlineshop.repository.EmployeeRepository;

import com.onlineshop.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	public EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
//	@Override
//	public EmployeeEntity saveUser(EmployeeEntity employeeEntity) {
//		
//		return employeeRepository.save(employeeEntity);
//	}

	@Override
	public List<EmployeeEntity> getAllEmployee() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Long getCount() {
		
		return employeeRepository.count();
	}

	@Override
	public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
		employeeRepository.save(employeeEntity);
		return null;
	}

	
	
	@Override
	public EmployeeEntity getEmployeeById(int productId) {		
		return employeeRepository.findById(productId).get();
	}

	
	@Override
	public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
		return employeeRepository.save(employeeEntity);
	}
	
	@Override
	public void deleteEmployee(int id) {

		employeeRepository.deleteById(id);
		
	}
	
}
