package com.dynagility.leavingtoolportal.VO;

import java.util.List;

public class DcVO {
	private String id;
	private String name;
	private EmployeeVO director;
	
	public DcVO() {
		super();
		// TODO Auto-generated constructor stub
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
	public EmployeeVO getDirector() {
		return director;
	}
	public void setDirector(EmployeeVO director) {
		this.director = director;
	}
	
	
}
