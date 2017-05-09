package com.dynagility.leavingtoolportal.model.mapper;

import com.dynagility.leavingtoolportal.VO.PositionVO;
import com.dynagility.leavingtoolportal.VO.ProjectVO;
import com.dynagility.leavingtoolportal.model.Position;
import com.dynagility.leavingtoolportal.model.Project;

public class ProjectMapper {
	public static ProjectVO updateRoleVO(Project project) {
		ProjectVO projectVO = new ProjectVO();
		projectVO.setId(project.getId() != null ? project.getId() : projectVO.getId());
		projectVO.setName(project.getName() != null ? project.getName() : projectVO.getName());
		projectVO.setProgram(project.getProgram() != null ? project.getProgram() : projectVO.getProgram());
		projectVO.setPm_Employee(project.getPmEmployee() != null ? project.getPmEmployee() : projectVO.getPm_Employee());
        return projectVO;
    }
	
	public static Project updateRole(ProjectVO projectVO) {
		Project project = new Project();
		project.setId(projectVO.getId() != null ? projectVO.getId() : project.getId());
		project.setName(projectVO.getName() != null ? projectVO.getName() : project.getName());
		project.setProgram(projectVO.getProgram() != null ? projectVO.getProgram() : project.getProgram());
		project.setPmEmployee(projectVO.getPm_Employee() != null ? projectVO.getPm_Employee() : project.getPmEmployee());
        return project;
    }

}
