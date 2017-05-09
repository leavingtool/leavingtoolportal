package com.dynagility.leavingtoolportal.VO;

public class Employee_ProjectVO {
	private String id;
	private EmployeeVO employee;
	private ProjectVO project;
	
	public Employee_ProjectVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee_ProjectVO(String id, EmployeeVO employee, ProjectVO project) {
		super();
		this.id = id;
		this.employee = employee;
		this.project = project;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EmployeeVO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeVO employee) {
		this.employee = employee;
	}

	public ProjectVO getProject() {
		return project;
	}

	public void setProject(ProjectVO project) {
		this.project = project;
	}
	
	

}
