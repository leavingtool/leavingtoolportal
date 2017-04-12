package com.dynagility.leavingtoolportal.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee_project")
public class EmployeeProject {
	private String id;
	private Employee employee;
	private Project project;
	
}
