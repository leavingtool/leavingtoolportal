package com.dynagility.leavingtoolportal.DaoImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dynagility.leavingtoolportal.Dao.DateTimeReasonDao;
import com.dynagility.leavingtoolportal.VO.DateTimeLeaveVO;
@Repository
@Transactional
public class DateTimeLeaveDaoImpl implements DateTimeReasonDao{

	@Override
	public DateTimeLeaveVO formatDateTime(DateTimeLeaveVO dateTimeLeaveVO) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy");
		dateTimeLeaveVO.setDate_from(sdf.format(Calendar.getInstance().getTime()));
		dateTimeLeaveVO.setDate_to(sdf.format(Calendar.getInstance().getTime()));
		return dateTimeLeaveVO;
	}
	

}
