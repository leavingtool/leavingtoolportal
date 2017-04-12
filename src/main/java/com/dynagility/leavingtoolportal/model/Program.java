package com.dynagility.leavingtoolportal.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "program")
public class Program {
	private String id;
	private String name;
	private Dc dc;
	private Employee employee;
	
	
}
