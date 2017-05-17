package com.dynagility.leavingtoolportal.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dynagility.leavingtoolportal.Dao.EmployeeProjectDao;
import com.dynagility.leavingtoolportal.VO.EmployeeProjectVO;
import com.dynagility.leavingtoolportal.model.EmployeeProject;
import com.dynagility.leavingtoolportal.model.mapper.EmployeeProjectMapper;

@Repository
@Transactional
public class EmployeeProjectDaoImpl implements EmployeeProjectDao {

	@PersistenceContext 
    private EntityManager entityManager;
	private EmployeeProjectMapper employeeProjectMapper;
	@SuppressWarnings("unchecked")
	@Override
    public List<EmployeeProjectVO> getAllEmProject(){
    	List<EmployeeProjectVO> empProVOs = new ArrayList<>();
    	List<EmployeeProject> empPros = (List<EmployeeProject>) entityManager.createQuery("from EmployeeProject").getResultList();
    	for(EmployeeProject e : empPros){
    		empProVOs.add(employeeProjectMapper.updateEmployeeProjectVO(e));
    	}
    	return empProVOs;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeProjectVO> getEmProjectByEmployeeId(String employeeId) {
		String hql = "select pro from EmployeeProject pro where employee_id =:employee_id";
		List<EmployeeProjectVO> empProVOs = new ArrayList<>();
		List<EmployeeProject> employeeProjects = null;
		employeeProjects =  (List<EmployeeProject>) entityManager.createQuery(hql).setParameter("employee_id", employeeId).getResultList();
		for(EmployeeProject e : employeeProjects){
    		empProVOs.add(employeeProjectMapper.updateEmployeeProjectVO(e));
    	}
		
		return empProVOs;
	}

}
