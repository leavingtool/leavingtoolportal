package com.dynagility.leavingtoolportal.VO;

import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.model.Role;

public class AccountVO {
	private String id;
	private String username;
	private Employee employee;
	private Role role;
	
	public AccountVO() {
		super();
	}
	
	public AccountVO(String id, String username, Employee employee, Role role) {
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
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
