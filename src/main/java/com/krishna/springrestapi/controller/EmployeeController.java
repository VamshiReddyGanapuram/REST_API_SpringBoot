package com.krishna.springrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.springrestapi.model.Department;
import com.krishna.springrestapi.model.Employee;
import com.krishna.springrestapi.repository.DepartmentRepository;
import com.krishna.springrestapi.repository.EmployeeRepository;
import com.krishna.springrestapi.response.EmployeeResponse;
import com.krishna.springrestapi.service.EmployeeService;
import com.krishna.sprintrestapi.request.EmployeeRequest;

import jakarta.validation.Valid;


@RestController //(Controller and ResponceBody)
public class EmployeeController {
	
	@Autowired
	private EmployeeService eService;
	
	@Autowired
	private EmployeeRepository eRepo;
	
	@Autowired
	private DepartmentRepository dRepo;
	
	
	
//	@GetMapping("/employees")	
//	public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
//		return new ResponseEntity<List<Employee>>(eService.getEmployees(pageNumber, pageSize),HttpStatus.OK);
//	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeResponse>> getEmployees(){
		List<Employee> list = eRepo.findAll();
		List<EmployeeResponse> responseList = new ArrayList<>();
		
		list.forEach(e -> {
			EmployeeResponse eResponse = new EmployeeResponse();
			eResponse.setId(e.getId());
			eResponse.setEmployeeName(e.getName());
			List<String> dept = new ArrayList<>();
			for (Department d : e.getDepartment()) {
				dept.add(d.getName());
			}
			eResponse.setDepartment(dept);
			responseList.add(eResponse);
		});
		return new ResponseEntity<List<EmployeeResponse>>(responseList, HttpStatus.OK);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmplloye(@PathVariable Long id) {
		return new ResponseEntity<Employee>(eService.getSingleEmployee(id), HttpStatus.OK);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<String> saveEmployee(@Valid @RequestBody EmployeeRequest eRequest) {
		
		//Employee is subclass here.
		Employee employee = new Employee(eRequest);
		//Getting EmployeeName
		employee=eRepo.save(employee);
		
		//Loop through multiple Departments
		for(String s : eRequest.getDepartment()) {
			Department d = new Department();
			d.setName(s);
			d.setEmployee(employee);
			
			dRepo.save(d);
		}
		return new ResponseEntity<String>("Record Saved Successfully",HttpStatus.OK);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmploye(@PathVariable Long id, @RequestBody Employee employee) {
		employee.setId(id);
		return new ResponseEntity<Employee>(eService.updateEmployee(employee), HttpStatus.OK);
	}
	
	@DeleteMapping("/employees")
	public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id) {
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		
	}
	

}
