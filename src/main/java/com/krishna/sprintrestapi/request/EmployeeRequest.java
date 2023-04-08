package com.krishna.sprintrestapi.request;

import java.util.List;

public class EmployeeRequest {
	
	private String name;
	
	private List<String> department;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getDepartment() {
		return department;
	}

	public void setDepartment(List<String> department) {
		this.department = department;
	}

	
	
	
}
