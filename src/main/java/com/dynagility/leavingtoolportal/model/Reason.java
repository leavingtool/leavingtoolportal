package com.dynagility.leavingtoolportal.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "reason")
public class Reason {
	private String id;
	private String name;
	private int leaveDays;
	
}
