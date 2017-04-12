package com.dynagility.leavingtoolportal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "leave_detail")
public class LeaveDetail {
	private String id;
	private Date leaveFrom;
	private Date leaveTo;
	private Employee employee;
	private Reason reason;
	private Status status;
	private String approver;
	
}
