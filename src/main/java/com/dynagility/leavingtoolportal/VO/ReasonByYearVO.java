package com.dynagility.leavingtoolportal.VO;

public class ReasonByYearVO {
	private String reason_name;
	private int preYear;
	private int number_of_leave_pre_year;
	private int nowYear;
	private int number_of_leave_now_year;
	private int nextYear;
	private int number_of_leave_next_year;
	public ReasonByYearVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getReason_name() {
		return reason_name;
	}
	public void setReason_name(String reason_name) {
		this.reason_name = reason_name;
	}
	public int getPreYear() {
		return preYear;
	}
	public void setPreYear(int preYear) {
		this.preYear = preYear;
	}
	public int getNumber_of_leave_pre_year() {
		return number_of_leave_pre_year;
	}
	public void setNumber_of_leave_pre_year(int number_of_leave_pre_year) {
		this.number_of_leave_pre_year = number_of_leave_pre_year;
	}
	public int getNowYear() {
		return nowYear;
	}
	public void setNowYear(int nowYear) {
		this.nowYear = nowYear;
	}
	public int getNumber_of_leave_now_year() {
		return number_of_leave_now_year;
	}
	public void setNumber_of_leave_now_year(int number_of_leave_now_year) {
		this.number_of_leave_now_year = number_of_leave_now_year;
	}
	public int getNextYear() {
		return nextYear;
	}
	public void setNextYear(int nextYear) {
		this.nextYear = nextYear;
	}
	public int getNumber_of_leave_next_year() {
		return number_of_leave_next_year;
	}
	public void setNumber_of_leave_next_year(int number_of_leave_next_year) {
		this.number_of_leave_next_year = number_of_leave_next_year;
	}
	public ReasonByYearVO(String reason_name, int preYear, int number_of_leave_pre_year, int nowYear,
			int number_of_leave_now_year, int nextYear, int number_of_leave_next_year) {
		super();
		this.reason_name = reason_name;
		this.preYear = preYear;
		this.number_of_leave_pre_year = number_of_leave_pre_year;
		this.nowYear = nowYear;
		this.number_of_leave_now_year = number_of_leave_now_year;
		this.nextYear = nextYear;
		this.number_of_leave_next_year = number_of_leave_next_year;
	}
	
	
}
