package com.dynagility.leavingtoolportal.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dynagility.leavingtoolportal.Dao.LeaveDetailDao;
import com.dynagility.leavingtoolportal.Dao.ReasonDao;
import com.dynagility.leavingtoolportal.VO.LeaveDetailVO;
import com.dynagility.leavingtoolportal.VO.LeaveReasonByYearVO;
import com.dynagility.leavingtoolportal.VO.ReasonByYearVO;
import com.dynagility.leavingtoolportal.VO.ReasonVO;
import com.dynagility.leavingtoolportal.exceptions.InternalErrorException;
import com.dynagility.leavingtoolportal.exceptions.NotFoundException;

@Service
public class LeaveReasonByYearService {
	@Autowired
	private LeaveDetailDao leaveDetailDao;
	@Autowired
	private ReasonDao reasonDao;
	
	public LeaveReasonByYearVO getLeaveReasonByYear(String employeeId){
			
			LeaveReasonByYearVO leaveReasonByYearVO = new LeaveReasonByYearVO();
			int year = Calendar.getInstance().get(Calendar.YEAR);
			int prev = year - 1;
			int next = year + 1;
			List<ReasonVO>listReason = reasonDao.getAllReason();
			List<ReasonByYearVO>listYear = new ArrayList<>();
			for (ReasonVO r : listReason){
				String reasonId = r.getId();
				List<LeaveDetailVO> leaveDetailPrevYear = leaveDetailDao.getEmployeeLeaveDetailVOByReasonAndYear(employeeId, reasonId, prev);
				List<LeaveDetailVO> leaveDetailYearNow = leaveDetailDao.getEmployeeLeaveDetailVOByReasonAndYear(employeeId, reasonId, year);
				List<LeaveDetailVO> leaveDetailNextYear = leaveDetailDao.getEmployeeLeaveDetailVOByReasonAndYear(employeeId, reasonId, next);
				ReasonByYearVO reasonByYearVO = new ReasonByYearVO();
				
				reasonByYearVO.setReason_name(r.getName());
				reasonByYearVO.setPre_year(prev);
				reasonByYearVO.setNumber_of_leave_pre_year(leaveDetailPrevYear.size());
				reasonByYearVO.setNow_year(year);
				reasonByYearVO.setNumber_of_leave_now_year(leaveDetailYearNow.size());
				reasonByYearVO.setNext_year(next);
				reasonByYearVO.setNumber_of_leave_pre_year(leaveDetailNextYear.size());
				listYear.add(reasonByYearVO);
			}
			leaveReasonByYearVO.setCheck(true);
			leaveReasonByYearVO.setData(listYear);
			return leaveReasonByYearVO;
			
		
	}
	 
}
