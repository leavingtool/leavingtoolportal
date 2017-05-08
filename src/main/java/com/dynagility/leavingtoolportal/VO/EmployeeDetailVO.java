package com.dynagility.leavingtoolportal.VO;

import java.util.List;

import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.model.Project;

public class EmployeeDetailVO extends Employee {
	private String role_id;
	private String role_name;
	private Project project;
//	private List<String> project_id;
//	private List<String> project_name;
	
	public EmployeeDetailVO(List<String> project_id, List<String> project_name, Project project, String role_id, String role_name) {
		super();
	
		this.role_id = role_id;
		this.role_name = role_name;
		this.project = project;
//		this.project_id = project_id;
//		this.project_name = project_name;
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

//	public List<String> getProject_id() {
//		return project_id;
//	}
//
//	public void setProject_id(List<String> project_id) {
//		this.project_id = project_id;
//	}
//
//	public List<String> getProject_name() {
//		return project_name;
//	}
//
//	public void setProject_name(List<String> project_name) {
//		this.project_name = project_name;
//	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
