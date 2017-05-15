package com.dynagility.leavingtoolportal.VO;

import java.util.List;

public class LeaveReasonByYearVO {
	private boolean check;
	private List<ReasonByYearVO>data;
	
	public LeaveReasonByYearVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LeaveReasonByYearVO(boolean check, List<ReasonByYearVO> data) {
		super();
		this.check = check;
		this.data = data;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public List<ReasonByYearVO> getData() {
		return data;
	}

	public void setData(List<ReasonByYearVO> data) {
		this.data = data;
	}

	

	


	
}
