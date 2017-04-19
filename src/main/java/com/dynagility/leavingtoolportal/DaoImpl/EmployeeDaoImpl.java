package com.dynagility.leavingtoolportal.DaoImpl;

import java.util.ArrayList;
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
        String hql = "from Employee";
        List<Employee> employees = null;
        employees = entityManager.createQuery(hql).getResultList();

        List<EmployeeVO> emVos = new ArrayList<EmployeeVO>();
        for(Employee e : employees) {
            emVos.add(new EmployeeVO(e));
        }
        return emVos;
    }

    public Employee findById(String id) {
        String hql = "select e from Employee e where id =:id";
        Employee employee = null;
        employee =  (Employee) entityManager.createQuery(hql).setParameter("id", id).getSingleResult();
        return employee;
    }

    @Override
    public EmployeeVO findEmployeeById(String id) {
        return new EmployeeVO(findById(id));
    }

    @Override
    public EmployeeVO findEmployeeByEmail(String email) {
        String hql = "select e from Employee e where email =:email";
        Employee employee = null;
        employee =  (Employee) entityManager.createQuery(hql).setParameter("email", email).getSingleResult();
        return new EmployeeVO(employee);
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

        entityManager.persist(entityManager.contains(employee) ? employee : entityManager.merge(employee));
    }

    @Override
    public void delete(EmployeeVO employeeVO) {

        entityManager.remove(findById(employeeVO.getId()));

//        entityManager.remove(entityManager.contains(employee) ? employee : entityManager.merge(employee));
    }
}
