package com.dynagility.leavingtoolportal.model.mapper;

import com.dynagility.leavingtoolportal.VO.EmployeeVO;
import com.dynagility.leavingtoolportal.VO.ReasonVO;
import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.model.Reason;

public class ReasonMapper {
	public static ReasonVO updateReasonVO(Reason reason) {
		ReasonVO reasonVO = new ReasonVO();
		reasonVO.setId(reason.getId() != null ? reason.getId() : reasonVO.getId());
		reasonVO.setName(reason.getName() != null ? reason.getName() : reasonVO.getName());
        return reasonVO;
    }
	
	public static Reason updateReason(ReasonVO source, Reason reason) {
        reason.setId(source.getId() != null ? source.getId() : reason.getId());
        reason.setName(source.getName() != null ? source.getName() : reason.getName());
        return reason;
    }

}
