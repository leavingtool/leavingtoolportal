package com.dynagility.leavingtoolportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dynagility.leavingtoolportal.Dao.DateTimeReasonDao;
import com.dynagility.leavingtoolportal.Dao.EmployeeDao;
import com.dynagility.leavingtoolportal.Dao.LeaveDetailDao;
import com.dynagility.leavingtoolportal.VO.DateTimeLeaveVO;
import com.dynagility.leavingtoolportal.VO.EmployeeVO;
import com.dynagility.leavingtoolportal.VO.LeaveDetailVO;
import com.dynagility.leavingtoolportal.exceptions.InternalErrorException;
import com.dynagility.leavingtoolportal.exceptions.NotFoundException;

@Service
public class LeaveDetailService {
	@Autowired
	private LeaveDetailDao leaveDetailDao;
	@Autowired
	private DateTimeReasonDao dateTimeReasonDao;
	@Autowired
	private EmployeeDao employeeDao;
	public List<LeaveDetailVO> getLeaveDetailById(String id){
		try {
			List<LeaveDetailVO> leaveDetailVo = null;
			leaveDetailVo = leaveDetailDao.getLeaveDetailVOByEmployeeId(id);
            return leaveDetailVo;
        }
        catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("LeaveDetail is not there");
        }
        catch (Exception ex) {
            throw new InternalErrorException(ex.getMessage());
        }
	}
	
	public List<LeaveDetailVO> getEmployeeLeaveDetailByReasonAndYear(String employeeId, String reason, int year){
		try {
			List<LeaveDetailVO> leaveDetailVo = null;
			leaveDetailVo = leaveDetailDao.getEmployeeLeaveDetailVOByReasonAndYear(employeeId, reason, year);
            return leaveDetailVo;
        }
        catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("LeaveDetail is not there");
        }
        catch (Exception ex) {
            throw new InternalErrorException(ex.getMessage());
        }
	}
	
	public DateTimeLeaveVO formatDateTimeLeaveVO(){
		DateTimeLeaveVO dateTimeLeaveVO = new DateTimeLeaveVO();
		
		return dateTimeReasonDao.formatDateTime(dateTimeLeaveVO);
	}

	public LeaveDetailVO addLeaveDetail(LeaveDetailVO newLeaveVO) {
        try {
        	return leaveDetailDao.save(newLeaveVO);
            
        }
        catch (Exception e) {
            throw new InternalErrorException(e.getMessage());
        }
    }
}
