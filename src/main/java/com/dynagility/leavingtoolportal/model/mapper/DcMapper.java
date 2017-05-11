package com.dynagility.leavingtoolportal.model.mapper;

import com.dynagility.leavingtoolportal.VO.DcVO;
import com.dynagility.leavingtoolportal.VO.Employee_ProjectVO;
import com.dynagility.leavingtoolportal.model.Dc;
import com.dynagility.leavingtoolportal.model.EmployeeProject;

public class DcMapper {
	public static DcVO updateDcVO(Dc dc) {
		DcVO dcVO = new DcVO();
		dcVO.setId(dc.getId() != null ? dc.getId() : dcVO.getId());
		dcVO.setName(dc.getName() != null ? dc.getName() : dcVO.getName());  
		return dcVO;
    }
}
