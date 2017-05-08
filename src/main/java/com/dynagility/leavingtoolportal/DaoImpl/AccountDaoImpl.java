package com.dynagility.leavingtoolportal.DaoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dynagility.leavingtoolportal.Dao.AccountDao;
import com.dynagility.leavingtoolportal.model.Account;
import com.dynagility.leavingtoolportal.model.Employee;

@Repository
@Transactional
public class AccountDaoImpl implements AccountDao {
	 @PersistenceContext 
	    private EntityManager entityManager;
	    @SuppressWarnings("unchecked")
	    @Override
	    public Account findByUserName(String username) {
	        String hql = "select ac from Account ac where username =:username";
	        Account account = null;
	        account =  (Account) entityManager.createQuery(hql).setParameter("username", username).getSingleResult();
	        return account;
	    }
	    
	    public Account findById(String id) {
	        String hql = "select ac from Account ac where id =:id";
	        Account account = null;
	        account =  (Account) entityManager.createQuery(hql).setParameter("id", id).getSingleResult();
	        return account;
	    }

		@Override
		public Account findByEmployeeId(String employeeId) {
			String hql = "select ac from Account ac where employee_id =:employee_id";
	        Account account = null;
	        account =  (Account) entityManager.createQuery(hql).setParameter("employee_id", employeeId).getSingleResult();
	        return account;
		}
}
