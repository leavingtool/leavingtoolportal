package com.dynagility.leavingtoolportal.DaoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dynagility.leavingtoolportal.Dao.EmployeeDao;
import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.object_value.EmployeeVO;
@Repository
@Transactional
public  class EmployeeDaoImpl implements EmployeeDao {
    @PersistenceContext 
    private EntityManager entityManager;
    @SuppressWarnings("unchecked")
    @Override
    public List<EmployeeVO> findAll(){
       return (List<EmployeeVO>) entityManager.createQuery("from Employee").getResultList();
    }

    @Override
    public EmployeeVO findById(String id) {
        String hql = "select e from Employee e where id =:id";
        EmployeeVO employeeVO = null;
        employeeVO =  (EmployeeVO) entityManager.createQuery(hql).setParameter("id", id).getSingleResult();
        return employeeVO;
    }

    @Override
    public void save(EmployeeVO employeeVO) {
        Employee employee =  new Employee();

        employee.setId(employeeVO.getId());
        employee.setName(employeeVO.getName());
        employee.setEmail(employeeVO.getEmail());
        employee.setBalanceDay(employeeVO.getBalanceDay());
        employee.setDeductedDay(employeeVO.getDeductedDay());
        employee.setPositionId(employeeVO.getPositionId());
        employee.setJoinDate(employeeVO.getJoinDate());
        
        entityManager.persist(employee);
    }

    @Override
    public void delete(EmployeeVO employeeVO) {
        entityManager.remove(employeeVO);
    }
}
