package com.dynagility.leavingtoolportal.model.mapper;

import com.dynagility.leavingtoolportal.VO.StatusVO;
import com.dynagility.leavingtoolportal.model.Status;

public class StatusMapper {
	public static StatusVO updateStatusVO(Status status) {
		StatusVO statusVO = new StatusVO();
		statusVO.setId(status.getId() != null ? status.getId() : statusVO.getId());
		statusVO.setName(status.getName() != null ? status.getName() : statusVO.getName());
        return statusVO;
    }
	
	public static Status updateStatus(StatusVO statusVO, Status status) {
		status.setId(statusVO.getId() != null ? statusVO.getId() : status.getId());
		status.setName(statusVO.getName() != null ? statusVO.getName() : status.getName());
		return status;
    }
}
