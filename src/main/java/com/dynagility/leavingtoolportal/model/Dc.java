package com.dynagility.leavingtoolportal.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dc")
public class Dc {
	private String id;
	private String name;
	private String directorEmployee;
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
	public String getDirectorEmployee() {
		return directorEmployee;
	}
	public void setDirectorEmployee(String directorEmployee) {
		this.directorEmployee = directorEmployee;
	}
	
}
