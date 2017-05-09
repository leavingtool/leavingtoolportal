package com.dynagility.leavingtoolportal.Dao;

import java.util.List;

import org.springframework.stereotype.Component;
import com.dynagility.leavingtoolportal.VO.Employee_ProjectVO;

@Component
public interface Employee_ProjectDao {
	public List<Employee_ProjectVO> getAllEm_Project();
	public List<Employee_ProjectVO> getEm_PojectByEmployeeId(String id); 
}
