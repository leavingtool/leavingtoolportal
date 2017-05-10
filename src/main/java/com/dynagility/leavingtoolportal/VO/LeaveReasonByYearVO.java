package com.dynagility.leavingtoolportal.VO;

public class LeaveReasonByYearVO {
	private boolean check;
	private String reason_name;
	private int number_of_reason_pre_year;
	private int number_of_reason_year_now;
	private int number_of_reason_next_year;
	
	public LeaveReasonByYearVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LeaveReasonByYearVO(String reason_name, int number_of_reason_pre_year, int number_of_reason_year_now,
			int number_of_reason_next_year) {
		super();
		this.reason_name = reason_name;
		this.number_of_reason_pre_year = number_of_reason_pre_year;
		this.number_of_reason_year_now = number_of_reason_year_now;
		this.number_of_reason_next_year = number_of_reason_next_year;
	}
	public String getReason_name() {
		return reason_name;
	}
	public void setReason_name(String reason_name) {
		this.reason_name = reason_name;
	}
	public int getNumber_of_reason_pre_year() {
		return number_of_reason_pre_year;
	}
	public void setNumber_of_reason_pre_year(int number_of_reason_pre_year) {
		this.number_of_reason_pre_year = number_of_reason_pre_year;
	}
	public int getNumber_of_reason_year_now() {
		return number_of_reason_year_now;
	}
	public void setNumber_of_reason_year_now(int number_of_reason_year_now) {
		this.number_of_reason_year_now = number_of_reason_year_now;
	}
	public int getNumber_of_reason_next_year() {
		return number_of_reason_next_year;
	}
	public void setNumber_of_reason_next_year(int number_of_reason_next_year) {
		this.number_of_reason_next_year = number_of_reason_next_year;
	}
	public boolean getCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	

	
}
