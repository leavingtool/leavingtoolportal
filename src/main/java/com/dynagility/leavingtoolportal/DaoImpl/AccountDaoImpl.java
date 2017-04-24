package com.dynagility.leavingtoolportal.DaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dynagility.leavingtoolportal.Dao.AccountDao;
import com.dynagility.leavingtoolportal.model.Account;

@Repository
@Transactional
public class AccountDaoImpl implements AccountDao{
	@PersistenceContext 
    private EntityManager entityManager;

	@Override
	public Account findByUsername(String username) {
		
		return (Account)entityManager.createQuery("select ac from Account ac where ac.username =:username").setParameter("username", username).getSingleResult();
	}

}
