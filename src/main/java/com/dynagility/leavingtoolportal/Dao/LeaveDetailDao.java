package com.dynagility.leavingtoolportal.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dynagility.leavingtoolportal.VO.LeaveDetailVO;

@Component
public interface LeaveDetailDao {
	public List<LeaveDetailVO> getAllLeaveDetailVO();
	public List<LeaveDetailVO> getLeaveDetailVOByEmployeeId(String id); 

}
