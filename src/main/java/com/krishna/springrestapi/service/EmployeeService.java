package com.krishna.springrestapi.service;

import java.util.List;

import com.krishna.springrestapi.model.Employee;

import jakarta.validation.Valid;

public interface EmployeeService {

	List<Employee> getEmployees(Integer pageNumber, Integer pageSize);

	Employee getSingleEmployee(Long id);

	Employee saveEmployee(@Valid Employee employee);

	Employee updateEmployee(Employee employee);
	
}
