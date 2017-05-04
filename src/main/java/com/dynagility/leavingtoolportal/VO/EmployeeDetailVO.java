package com.dynagility.leavingtoolportal.VO;

import com.dynagility.leavingtoolportal.model.Employee;

public class EmployeeDetailVO extends Employee {
	private String role_id;
	private String role_name;
	
	public EmployeeDetailVO(String role_id, String role_name) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
	}

	public EmployeeDetailVO(Employee _employee) {
		super();
		// TODO Auto-generated constructor stub
		this.update(_employee);
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	

}
