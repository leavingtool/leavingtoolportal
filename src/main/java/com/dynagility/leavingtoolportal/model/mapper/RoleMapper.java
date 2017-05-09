package com.dynagility.leavingtoolportal.model.mapper;

import com.dynagility.leavingtoolportal.VO.EmployeeVO;
import com.dynagility.leavingtoolportal.VO.RoleVO;
import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.model.Role;

public class RoleMapper {
	public static RoleVO updateRoleVO(Role role) {
		RoleVO roleVo = new RoleVO();
        roleVo.setId(role.getId() != null ? role.getId() : roleVo.getId());
        roleVo.setName(role.getName() != null ? role.getName() : roleVo.getName());
        return roleVo;
    }
}
