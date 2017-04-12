package com.dynagility.leavingtoolportal.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {
	private String id;
	private String name;
	private Program program;
	private Employee employee;

	
}
