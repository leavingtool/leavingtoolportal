package com.dynagility.leavingtoolportal.Dao;

import org.springframework.stereotype.Component;

import com.dynagility.leavingtoolportal.VO.DateTimeLeaveVO;
@Component
public interface DateTimeReasonDao {
	public DateTimeLeaveVO formatDateTime(DateTimeLeaveVO dateTimeLeaveVO);
}	
