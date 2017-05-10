package com.dynagility.leavingtoolportal.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dynagility.leavingtoolportal.Dao.LeaveDetailDao;
import com.dynagility.leavingtoolportal.Dao.ReasonDao;
import com.dynagility.leavingtoolportal.VO.LeaveDetailVO;
import com.dynagility.leavingtoolportal.VO.LeaveReasonByYearVO;
import com.dynagility.leavingtoolportal.VO.ReasonVO;
import com.dynagility.leavingtoolportal.exceptions.InternalErrorException;
import com.dynagility.leavingtoolportal.exceptions.NotFoundException;

@Service
public class LeaveReasonByYearService {
	@Autowired
	private LeaveDetailDao leaveDetailDao;
	@Autowired
	private ReasonDao reasonDao;
	
	public LeaveReasonByYearVO getLeaveReasonByYear(String employee_id, String reason_id, int year){
			//try{
			LeaveReasonByYearVO leaveReasonByYearVO = new LeaveReasonByYearVO();
			List<LeaveDetailVO> leaveDetail_prev_year = leaveDetailDao.getEmployeeLeaveDetailVOByReasonAndYear(employee_id, reason_id, year - 1);
			List<LeaveDetailVO> leaveDetail_year_now = leaveDetailDao.getEmployeeLeaveDetailVOByReasonAndYear(employee_id, reason_id, year);
			List<LeaveDetailVO> leaveDetail_next_year = leaveDetailDao.getEmployeeLeaveDetailVOByReasonAndYear(employee_id, reason_id, year + 1);
			ReasonVO reasonVO = reasonDao.getReasonByReasonId(reason_id);
			
			leaveReasonByYearVO.setCheck(true);
			leaveReasonByYearVO.setReason_name(reasonVO.getName());
			leaveReasonByYearVO.setNumber_of_reason_pre_year(leaveDetail_prev_year.size());
			leaveReasonByYearVO.setNumber_of_reason_year_now(leaveDetail_year_now.size());
			leaveReasonByYearVO.setNumber_of_reason_next_year(leaveDetail_next_year.size());
			
			return leaveReasonByYearVO;
			/*}
			catch (EmptyResultDataAccessException e) {
	            throw new NotFoundException("Wrong Parameter");
	        }
	        catch (Exception ex) {
	            throw new InternalErrorException(ex.getMessage());
	        }*/
		
	}
	 
}
