package com.dynagility.leavingtoolportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dynagility.leavingtoolportal.Dao.LeaveDetailDao;
import com.dynagility.leavingtoolportal.VO.LeaveDetailVO;
import com.dynagility.leavingtoolportal.exceptions.InternalErrorException;
import com.dynagility.leavingtoolportal.exceptions.NotFoundException;

@Service
public class LeaveDetailService {
	@Autowired
	private LeaveDetailDao leaveDetailDao;
	
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
	
	public List<LeaveDetailVO> getEmployeeLeaveDetailByReasonAndYear(String employee_id, String reason, int year){
		try {
			List<LeaveDetailVO> leaveDetailVo = null;
			leaveDetailVo = leaveDetailDao.getEmployeeLeaveDetailVOByReasonAndYear(employee_id, reason, year);
            return leaveDetailVo;
        }
        catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("LeaveDetail is not there");
        }
        catch (Exception ex) {
            throw new InternalErrorException(ex.getMessage());
        }
	}

}
