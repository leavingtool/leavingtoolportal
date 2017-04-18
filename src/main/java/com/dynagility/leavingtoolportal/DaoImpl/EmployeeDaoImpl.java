package com.dynagility.leavingtoolportal.DaoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dynagility.leavingtoolportal.Dao.EmployeeDao;
import com.dynagility.leavingtoolportal.exceptions.NotFoundException;
import com.dynagility.leavingtoolportal.model.Employee;
@Repository
@Transactional
public  class EmployeeDaoImpl implements EmployeeDao {
    @PersistenceContext 
    private EntityManager entityManager;
    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> findAll(){
       return (List<Employee>) entityManager.createQuery("from Employee").getResultList();
    }

    @Override
    public Employee findById(String id) {
        String hql = "select e from Employee e where id =:id";
        Employee employee = null;
        employee =  (Employee) entityManager.createQuery(hql).setParameter("id", id).getSingleResult();
        return employee;
    }

    @Override
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public void delete(Employee employee) {
        entityManager.remove(employee);
    }
}
