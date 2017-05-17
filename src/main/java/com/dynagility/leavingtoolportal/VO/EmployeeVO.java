package com.dynagility.leavingtoolportal.VO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EmployeeVO implements Serializable {
    private String id;
    private String name;
    private String email;
    private Integer balance_day;
    private Integer deducted_day;
    private Date join_date;
    private RoleVO role;
    private String position_name;
    private List<String> projects;
    
    public EmployeeVO() {
    }

	public EmployeeVO(String id, String name, String email, Integer balance_day, Integer deducted_day, Date join_date,
			RoleVO role, String position_name, List<String> projects) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.balance_day = balance_day;
		this.deducted_day = deducted_day;
		this.join_date = join_date;
		this.role = role;
		this.position_name = position_name;
		this.projects = projects;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getBalance_day() {
		return balance_day;
	}

	public void setBalance_day(Integer balance_day) {
		this.balance_day = balance_day;
	}

	public Integer getDeducted_day() {
		return deducted_day;
	}

	public void setDeducted_day(Integer deducted_day) {
		this.deducted_day = deducted_day;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public RoleVO getRole() {
		return role;
	}

	public void setRole(RoleVO role) {
		this.role = role;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

	public List<String> getProjects() {
		return projects;
	}

	public void setProjects(List<String> projects) {
		this.projects = projects;
	}

	

	
}
