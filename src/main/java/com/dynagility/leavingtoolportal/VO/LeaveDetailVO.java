package com.dynagility.leavingtoolportal.VO;

import java.util.Date;
import java.util.List;

import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.model.Reason;
import com.dynagility.leavingtoolportal.model.Status;

public class LeaveDetailVO {
	private String id;
	private Date leave_from;
	private Date leave_to;
	private ReasonVO reason;
	private StatusVO status;
	private List<EmployeeVO> approvers;
	public LeaveDetailVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LeaveDetailVO(String id, Date leave_from, Date leave_to, ReasonVO reason, StatusVO status,
			List<EmployeeVO> approvers) {
		super();
		this.id = id;
		this.leave_from = leave_from;
		this.leave_to = leave_to;
		this.reason = reason;
		this.status = status;
		this.approvers = approvers;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getLeave_from() {
		return leave_from;
	}
	public void setLeave_from(Date leave_from) {
		this.leave_from = leave_from;
	}
	public Date getLeave_to() {
		return leave_to;
	}
	public void setLeave_to(Date leave_to) {
		this.leave_to = leave_to;
	}
	public ReasonVO getReason() {
		return reason;
	}
	public void setReason(ReasonVO reason) {
		this.reason = reason;
	}
	public StatusVO getStatus() {
		return status;
	}
	public void setStatus(StatusVO status) {
		this.status = status;
	}
	public List<EmployeeVO> getApprovers() {
		return approvers;
	}
	public void setApprovers(List<EmployeeVO> approvers) {
		this.approvers = approvers;
	}
}
