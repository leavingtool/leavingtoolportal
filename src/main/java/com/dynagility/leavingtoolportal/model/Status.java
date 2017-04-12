package com.dynagility.leavingtoolportal.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "status")
public class Status {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", nullable = false, length = 255)
	private String id;

	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "status")
	private Set<LeaveDetail> leaveDetails = new HashSet<LeaveDetail>(0);

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

	public Set<LeaveDetail> getLeaveDetails() {
		return leaveDetails;
	}

	public void setLeaveDetails(Set<LeaveDetail> leaveDetails) {
		this.leaveDetails = leaveDetails;
	}

}
