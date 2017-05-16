package com.dynagility.leavingtoolportal.model.mapper;

import com.dynagility.leavingtoolportal.VO.EmployeeProjectVO;
import com.dynagility.leavingtoolportal.VO.ProgramVO;
import com.dynagility.leavingtoolportal.model.EmployeeProject;
import com.dynagility.leavingtoolportal.model.Program;

public class ProgramMapper {
	private static DcMapper dcMapper;
	private static EmployeeMapper employeeMapper;
	public static ProgramVO updateProgramVO(Program program) {
		ProgramVO programVO = new ProgramVO();
		programVO.setId(program.getId() != null ? program.getId() : programVO.getId());
		programVO.setName(program.getName() != null ? program.getName() : programVO.getName());
		programVO.setDc(program.getDc() != null ? dcMapper.updateDcVO(program.getDc()) : programVO.getDc());
		programVO.setSm_pc(program.getSmPcEmployee() != null ? employeeMapper.updateEmployeeVO(program.getSmPcEmployee()) : programVO.getSm_pc());
        return programVO;
    }
}
