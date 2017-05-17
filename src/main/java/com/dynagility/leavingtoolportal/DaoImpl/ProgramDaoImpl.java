package com.dynagility.leavingtoolportal.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dynagility.leavingtoolportal.Dao.ProgramDao;
import com.dynagility.leavingtoolportal.VO.EmployeeProjectVO;
import com.dynagility.leavingtoolportal.VO.ProgramVO;
import com.dynagility.leavingtoolportal.model.EmployeeProject;
import com.dynagility.leavingtoolportal.model.Program;
import com.dynagility.leavingtoolportal.model.mapper.EmployeeProjectMapper;
import com.dynagility.leavingtoolportal.model.mapper.ProgramMapper;

@Repository
@Transactional
public class ProgramDaoImpl implements ProgramDao{
	@PersistenceContext 
    private EntityManager entityManager;
	private ProgramMapper programMapper;
	@SuppressWarnings("unchecked")
	@Override
	public ProgramVO getProgramByProgramId(String programId) {
		String hql = "select pro from Program pro where id =:program_id";
		Program program = (Program) entityManager.createQuery(hql).setParameter("program_id", programId).getSingleResult();
		ProgramVO programVO = programMapper.updateProgramVO(program);
		return programVO;
	}
	
}
