package com.dynagility.leavingtoolportal.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dynagility.leavingtoolportal.VO.ReasonVO;
@Component
public interface ReasonDao {
	public ReasonVO getReasonByReasonId(String reasonId);
	public List<ReasonVO> getAllReason();
}
