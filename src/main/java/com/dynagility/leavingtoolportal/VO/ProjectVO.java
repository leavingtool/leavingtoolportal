package com.dynagility.leavingtoolportal.VO;

import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.model.Program;

public class ProjectVO {
	private String id;
	private String name;
	private Program program;
	private Employee pm_Employee;
	
	
	public ProjectVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProjectVO(String id, String name, Program program, Employee pm_Employee) {
		super();
		this.id = id;
		this.name = name;
		this.program = program;
		this.pm_Employee = pm_Employee;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Program getProgram() {
		return program;
	}


	public void setProgram(Program program) {
		this.program = program;
	}


	public Employee getPm_Employee() {
		return pm_Employee;
	}


	public void setPm_Employee(Employee pm_Employee) {
		this.pm_Employee = pm_Employee;
	}

}
