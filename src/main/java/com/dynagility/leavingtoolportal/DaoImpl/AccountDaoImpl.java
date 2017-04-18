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
	    public Account findById(String username) {
	        String hql = "select ac from Account ac where username =:username";
	        Account account = null;
	        account =  (Account) entityManager.createQuery(hql).setParameter("username", username).getSingleResult();
	        return account;
	    }

}
