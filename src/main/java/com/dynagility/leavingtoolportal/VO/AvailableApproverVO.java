package com.dynagility.leavingtoolportal.VO;

import java.util.List;

public class AvailableApproverVO {
	private List<EmployeeVO> director;
	private List<EmployeeVO> sm_pc;
	private List<EmployeeVO> pm;
	public AvailableApproverVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<EmployeeVO> getDirector() {
		return director;
	}
	public void setDirector(List<EmployeeVO> director) {
		this.director = director;
	}
	public List<EmployeeVO> getSm_pc() {
		return sm_pc;
	}
	public void setSm_pc(List<EmployeeVO> sm_pc) {
		this.sm_pc = sm_pc;
	}
	public List<EmployeeVO> getPm() {
		return pm;
	}
	public void setPm(List<EmployeeVO> pm) {
		this.pm = pm;
	}

	
	
}
