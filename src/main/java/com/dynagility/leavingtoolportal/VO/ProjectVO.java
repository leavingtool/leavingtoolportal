package com.dynagility.leavingtoolportal.VO;

import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.model.Program;

public class ProjectVO {
	private String id;
	private String name;
	private ProgramVO program;
	private EmployeeVO pm_Employee;
	
	
	public ProjectVO() {
		super();
	}


	public ProjectVO(String id, String name, ProgramVO program, EmployeeVO pm_Employee) {
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


	public ProgramVO getProgram() {
		return program;
	}


	public void setProgram(ProgramVO program) {
		this.program = program;
	}


	public EmployeeVO getPm_Employee() {
		return pm_Employee;
	}


	public void setPm_Employee(EmployeeVO pm_Employee) {
		this.pm_Employee = pm_Employee;
	}





	
}
