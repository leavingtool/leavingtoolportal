package com.dynagility.leavingtoolportal.Dao;

import java.util.List;

import org.springframework.stereotype.Component;
import com.dynagility.leavingtoolportal.VO.EmployeeProjectVO;

@Component
public interface EmployeeProjectDao {
	public List<EmployeeProjectVO> getAllEmProject();
	public List<EmployeeProjectVO> getEmProjectByEmployeeId(String id); 
}
