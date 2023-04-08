package com.krishna.springrestapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krishna.springrestapi.model.Employee;
import com.krishna.springrestapi.repository.EmployeeRepository;

import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository eRepository;

	@Override
	public List<Employee> getEmployees(Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getSingleEmployee(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee saveEmployee(@Valid Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}
}
