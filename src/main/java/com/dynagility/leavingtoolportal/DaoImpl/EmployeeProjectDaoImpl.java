package com.dynagility.leavingtoolportal.DaoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dynagility.leavingtoolportal.Dao.EmployeeProjectDao;
import com.dynagility.leavingtoolportal.model.EmployeeProject;

@Repository
@Transactional
public class EmployeeProjectDaoImpl implements EmployeeProjectDao {

	@PersistenceContext 
    private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
    public List<EmployeeProject> getAllEm_Project(){
       return (List<EmployeeProject>) entityManager.createQuery("from EmployeeProject").getResultList();
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeProject> getEm_PojectByEmployeeId(String emloyeeId) {
		String hql = "select pro from EmployeeProject pro where employee_id =:emloyeeId";
		List<EmployeeProject> employeeProject = null;
		employeeProject =  (List<EmployeeProject>) entityManager.createQuery(hql).setParameter("emloyeeId", emloyeeId).getResultList();
		return employeeProject;
	}

}
