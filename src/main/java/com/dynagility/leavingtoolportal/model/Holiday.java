package com.dynagility.leavingtoolportal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "holiday")
public class Holiday {
	private String id;
	private Date dateFrom;
	private Date dateTo;
	
}
