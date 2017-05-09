package com.dynagility.leavingtoolportal.VO;

public class LoginVO {
	private String id;
	private RoleVO role;
	private Boolean status = false;
	
	public LoginVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginVO(String id, RoleVO role, Boolean status) {
		super();
		this.id = id;
		this.role = role;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RoleVO getRole() {
		return role;
	}

	public void setRole(RoleVO role) {
		this.role = role;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
