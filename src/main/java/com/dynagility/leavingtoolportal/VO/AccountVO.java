package com.dynagility.leavingtoolportal.VO;

import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.model.Role;

public class AccountVO {
	private String id;
	private String username;
	private EmployeeVO employee;
	private RoleVO role;
	
	public AccountVO() {
		super();
	}

	public AccountVO(String id, String username, EmployeeVO employee, RoleVO role) {
		super();
		this.id = id;
		this.username = username;
		this.employee = employee;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public EmployeeVO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeVO employee) {
		this.employee = employee;
	}

	public RoleVO getRole() {
		return role;
	}

	public void setRole(RoleVO role) {
		this.role = role;
	}
	
	
}
