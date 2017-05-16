package com.dynagility.leavingtoolportal.model.mapper;

import com.dynagility.leavingtoolportal.VO.EmployeeProjectVO;
import com.dynagility.leavingtoolportal.VO.PositionVO;
import com.dynagility.leavingtoolportal.model.EmployeeProject;
import com.dynagility.leavingtoolportal.model.Position;

public class EmployeeProjectMapper {
	
	public static EmployeeProjectVO updateEmployeeProjectVO(EmployeeProject employeeProject) {
		EmployeeProjectVO employeeProjectVO = new EmployeeProjectVO();
		employeeProjectVO.setId(employeeProject.getId() != null ? employeeProject.getId() : employeeProjectVO.getId());
		employeeProjectVO.setProject(employeeProject.getProject() != null ? ProjectMapper.updateProjectVO(employeeProject.getProject()) : employeeProjectVO.getProject());
        return employeeProjectVO;
    }

}
