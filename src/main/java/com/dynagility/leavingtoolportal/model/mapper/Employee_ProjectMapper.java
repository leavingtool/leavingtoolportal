package com.dynagility.leavingtoolportal.model.mapper;

import com.dynagility.leavingtoolportal.VO.Employee_ProjectVO;
import com.dynagility.leavingtoolportal.VO.PositionVO;
import com.dynagility.leavingtoolportal.model.EmployeeProject;
import com.dynagility.leavingtoolportal.model.Position;

public class Employee_ProjectMapper {
	private static ProjectMapper projectMapper;
	public static Employee_ProjectVO updateRoleVO(EmployeeProject employeeProject) {
		Employee_ProjectVO employee_ProjectVO = new Employee_ProjectVO();
		employee_ProjectVO.setId(employeeProject.getId() != null ? employeeProject.getId() : employee_ProjectVO.getId());
		employee_ProjectVO.setProject(employeeProject.getProject() != null ? projectMapper.updateRoleVO(employeeProject.getProject()) : employee_ProjectVO.getProject());
        return employee_ProjectVO;
    }

}