package com.dynagility.leavingtoolportal.Dao;

import org.springframework.stereotype.Component;

import com.dynagility.leavingtoolportal.VO.ProgramVO;
@Component
public interface ProgramDao {
	public ProgramVO getProgramByProgramId(String program_id);
}
