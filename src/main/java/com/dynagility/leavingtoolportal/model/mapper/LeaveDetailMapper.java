package com.dynagility.leavingtoolportal.model.mapper;

import com.dynagility.leavingtoolportal.VO.EmployeeVO;
import com.dynagility.leavingtoolportal.VO.LeaveDetailVO;
import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.model.LeaveDetail;

public class LeaveDetailMapper {
	
	public static LeaveDetailVO updateLeaveDetailVO(LeaveDetail leavDetail) {
		LeaveDetailVO leaveDetailVO = new LeaveDetailVO();
		leaveDetailVO.setId(leavDetail.getId() != null ? leavDetail.getId() : leaveDetailVO.getId());
		leaveDetailVO.setLeave_from(leavDetail.getLeaveFrom() != null ? leavDetail.getLeaveFrom() : leaveDetailVO.getLeave_from());
		leaveDetailVO.setLeave_to(leavDetail.getLeaveTo() != null ? leavDetail.getLeaveTo() : leaveDetailVO.getLeave_to());
		leaveDetailVO.setReason(leavDetail.getReason() != null ? ReasonMapper.updateReasonVO(leavDetail.getReason()) : leaveDetailVO.getReason());
		leaveDetailVO.setStatus(leavDetail.getStatus() != null ? StatusMapper.updateStatusVO(leavDetail.getStatus()) : leaveDetailVO.getStatus());
		leaveDetailVO.setDeducted_days(leavDetail.getDeducted_days() != null ? leavDetail.getDeducted_days() : leaveDetailVO.getDeducted_days());
		leaveDetailVO.setEmployee(leavDetail.getEmployee().getId() != null ? leavDetail.getEmployee().getId() : leaveDetailVO.getEmployee());
		return leaveDetailVO;
    }
	
	public static LeaveDetail updateLeaveDetail(LeaveDetailVO source, LeaveDetail leaveDetail) {
        leaveDetail.setLeaveFrom(source.getLeave_from() != null ? source.getLeave_from() : leaveDetail.getLeaveFrom());
        leaveDetail.setLeaveTo(source.getLeave_to() != null ? source.getLeave_to() : leaveDetail.getLeaveTo());
        leaveDetail.setReason(source.getReason() != null ? ReasonMapper.updateReason(source.getReason(), leaveDetail.getReason()) : leaveDetail.getReason());
        leaveDetail.setStatus(source.getStatus() != null ? StatusMapper.updateStatus(source.getStatus(), leaveDetail.getStatus()) : leaveDetail.getStatus());
        leaveDetail.setDeducted_days(source.getDeducted_days() != null ? source.getDeducted_days() : leaveDetail.getDeducted_days());

        return leaveDetail;
    }
	
}
