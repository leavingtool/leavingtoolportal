package com.dynagility.leavingtoolportal.VO;

public class ReasonByYearVO {
	private String reason_name;
	private int pre_year;
	private int number_of_leave_pre_year;
	private int now_year;
	private int number_of_leave_now_year;
	private int next_year;
	private int number_of_leave_next_year;
	public ReasonByYearVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReasonByYearVO(String reason_name, int pre_year, int number_of_leave_pre_year, int now_year,
			int number_of_leave_now_year, int next_year, int number_of_leave_next_year) {
		super();
		this.reason_name = reason_name;
		this.pre_year = pre_year;
		this.number_of_leave_pre_year = number_of_leave_pre_year;
		this.now_year = now_year;
		this.number_of_leave_now_year = number_of_leave_now_year;
		this.next_year = next_year;
		this.number_of_leave_next_year = number_of_leave_next_year;
	}
	public String getReason_name() {
		return reason_name;
	}
	public void setReason_name(String reason_name) {
		this.reason_name = reason_name;
	}
	public int getPre_year() {
		return pre_year;
	}
	public void setPre_year(int pre_year) {
		this.pre_year = pre_year;
	}
	public int getNumber_of_leave_pre_year() {
		return number_of_leave_pre_year;
	}
	public void setNumber_of_leave_pre_year(int number_of_leave_pre_year) {
		this.number_of_leave_pre_year = number_of_leave_pre_year;
	}
	public int getNow_year() {
		return now_year;
	}
	public void setNow_year(int now_year) {
		this.now_year = now_year;
	}
	public int getNumber_of_leave_now_year() {
		return number_of_leave_now_year;
	}
	public void setNumber_of_leave_now_year(int number_of_leave_now_year) {
		this.number_of_leave_now_year = number_of_leave_now_year;
	}
	public int getNext_year() {
		return next_year;
	}
	public void setNext_year(int next_year) {
		this.next_year = next_year;
	}
	public int getNumber_of_leave_next_year() {
		return number_of_leave_next_year;
	}
	public void setNumber_of_leave_next_year(int number_of_leave_next_year) {
		this.number_of_leave_next_year = number_of_leave_next_year;
	}
	
	
	
}
