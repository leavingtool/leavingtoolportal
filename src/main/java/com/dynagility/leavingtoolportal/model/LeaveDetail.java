package com.dynagility.leavingtoolportal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "leave_detail")
public class LeaveDetail {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", nullable = false, length = 255)
	private String id;

	@Temporal(TemporalType.DATE)
	@Column(name = "leave_from", length = 0)
	private Date leaveFrom;

	@Temporal(TemporalType.DATE)
	@Column(name = "leave_to", length = 0)
	private Date leaveTo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reason_id", nullable = false)
	private Reason reason;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_id", nullable = false)
	private Status status;

	@Column(name = "approver", nullable = false, length = 255)
	private String approver;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getLeaveFrom() {
		return leaveFrom;
	}

	public void setLeaveFrom(Date leaveFrom) {
		this.leaveFrom = leaveFrom;
	}

	public Date getLeaveTo() {
		return leaveTo;
	}

	public void setLeaveTo(Date leaveTo) {
		this.leaveTo = leaveTo;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Reason getReason() {
		return reason;
	}

	public void setReason(Reason reason) {
		this.reason = reason;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

}
