package com.dynagility.leavingtoolportal.VO;

public class ReasonVO {
	private String id;
	private String name;
	
	public ReasonVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReasonVO(String id, String name) {
		super();
		this.id = id;
		this.name = name;
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

}
