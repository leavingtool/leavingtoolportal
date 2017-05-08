package com.dynagility.leavingtoolportal.Dao;

import java.util.List;

import org.springframework.stereotype.Component;
import com.dynagility.leavingtoolportal.model.EmployeeProject;


@Component
public interface EmployeeProjectDao {
	
	public List<EmployeeProject> getAllEm_Project();
	public List<EmployeeProject> getEm_PojectByEmployeeId(String id);
}
