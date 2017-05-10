package com.dynagility.leavingtoolportal.model.mapper;

import com.dynagility.leavingtoolportal.VO.LeaveDetailVO;
import com.dynagility.leavingtoolportal.model.LeaveDetail;

public class LeaveDetailMapper {
	private static StatusMapper statusMapper;
	private static ReasonMapper reasonMapper;
	
	public static LeaveDetailVO updateLeaveDetailVO(LeaveDetail leavDetail) {
		LeaveDetailVO leaveDetailVO = new LeaveDetailVO();
		leaveDetailVO.setId(leavDetail.getId() != null ? leavDetail.getId() : leaveDetailVO.getId());
		leaveDetailVO.setLeave_from(leavDetail.getLeaveFrom() != null ? leavDetail.getLeaveFrom() : leaveDetailVO.getLeave_from());
		leaveDetailVO.setLeave_to(leavDetail.getLeaveTo() != null ? leavDetail.getLeaveTo() : leaveDetailVO.getLeave_to());
		leaveDetailVO.setReason(leavDetail.getReason() != null ? reasonMapper.updateReasonVO(leavDetail.getReason()) : leaveDetailVO.getReason());
		leaveDetailVO.setStatus(leavDetail.getStatus() != null ? statusMapper.updateStatusVO(leavDetail.getStatus()) : leaveDetailVO.getStatus());
        return leaveDetailVO;
    }

}
