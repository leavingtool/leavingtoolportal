package com.dynagility.leavingtoolportal.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status {
	private String id;
	private String name;
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
