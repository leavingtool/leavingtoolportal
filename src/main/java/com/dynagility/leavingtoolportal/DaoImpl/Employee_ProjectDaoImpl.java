package com.dynagility.leavingtoolportal.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dynagility.leavingtoolportal.Dao.Employee_ProjectDao;
import com.dynagility.leavingtoolportal.VO.Employee_ProjectVO;
import com.dynagility.leavingtoolportal.model.EmployeeProject;
import com.dynagility.leavingtoolportal.model.mapper.Employee_ProjectMapper;

@Repository
@Transactional
public class Employee_ProjectDaoImpl implements Employee_ProjectDao {

	@PersistenceContext 
    private EntityManager entityManager;
	private Employee_ProjectMapper employee_ProjectMapper;
	@SuppressWarnings("unchecked")
	@Override
    public List<Employee_ProjectVO> getAllEm_Project(){
    	List<Employee_ProjectVO> emp_ProVOs = new ArrayList<>();
    	List<EmployeeProject> emp_Pros = (List<EmployeeProject>) entityManager.createQuery("from EmployeeProject").getResultList();
    	for(EmployeeProject e : emp_Pros){
    		emp_ProVOs.add(employee_ProjectMapper.updateRoleVO(e));
    	}
    	return emp_ProVOs;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee_ProjectVO> getEm_PojectByEmployeeId(String emloyeeId) {
		String hql = "select pro from EmployeeProject pro where employee_id =:emloyeeId";
		List<Employee_ProjectVO> emp_ProVOs = new ArrayList<>();
		List<EmployeeProject> employeeProjects = null;
		employeeProjects =  (List<EmployeeProject>) entityManager.createQuery(hql).setParameter("emloyeeId", emloyeeId).getResultList();
		for(EmployeeProject e : employeeProjects){
    		emp_ProVOs.add(employee_ProjectMapper.updateRoleVO(e));
    	}
		return emp_ProVOs;
	}

}
