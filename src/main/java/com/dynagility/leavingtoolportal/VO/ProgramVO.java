package com.dynagility.leavingtoolportal.VO;

import java.util.List;

public class ProgramVO {
	private String id;
	private String name;
	private DcVO dc;
	private List<ProjectVO>list_project;
	private EmployeeVO sm_pc;
	
	public ProgramVO() {
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
	
	public EmployeeVO getSm_pc() {
		return sm_pc;
	}
	public void setSm_pc(EmployeeVO sm_pc) {
		this.sm_pc = sm_pc;
	}
	public List<ProjectVO> getList_project() {
		return list_project;
	}
	public void setList_project(List<ProjectVO> list_project) {
		this.list_project = list_project;
	}
	public DcVO getDc() {
		return dc;
	}
	public void setDc(DcVO dc) {
		this.dc = dc;
	}
	
	
	
	
	
}
