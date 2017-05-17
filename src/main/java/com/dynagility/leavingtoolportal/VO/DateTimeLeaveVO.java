package com.dynagility.leavingtoolportal.VO;

import java.util.Calendar;
import java.util.Date;

public class DateTimeLeaveVO {
	private String time_from_start;
	private String time_from_end;
	private String date_from;
	private String time_to_start;
	private String time_to_end;
	private String date_to;
	
	public DateTimeLeaveVO() {
		super();
		// TODO Auto-generated constructor stub
		time_from_start = "08:30";
		time_from_end = "13:30";
		time_to_start = "12:00";
		time_to_end = "18:00";
		
	}

	public String getTime_from_start() {
		return time_from_start;
	}

	public void setTime_from_start(String time_from_start) {
		this.time_from_start = time_from_start;
	}

	public String getTime_from_end() {
		return time_from_end;
	}

	public void setTime_from_end(String time_from_end) {
		this.time_from_end = time_from_end;
	}

	public String getDate_from() {
		return date_from;
	}

	public void setDate_from(String date_from) {
		this.date_from = date_from;
	}

	public String getTime_to_start() {
		return time_to_start;
	}

	public void setTime_to_start(String time_to_start) {
		this.time_to_start = time_to_start;
	}

	public String getTime_to_end() {
		return time_to_end;
	}

	public void setTime_to_end(String time_to_end) {
		this.time_to_end = time_to_end;
	}

	public String getDate_to() {
		return date_to;
	}

	public void setDate_to(String date_to) {
		this.date_to = date_to;
	}

	
	
	
}
