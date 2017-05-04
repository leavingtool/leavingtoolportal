package com.dynagility.leavingtoolportal.DaoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dynagility.leavingtoolportal.Dao.AccountDao;
import com.dynagility.leavingtoolportal.Dao.EmployeeDetailDao;
import com.dynagility.leavingtoolportal.VO.EmployeeDetailVO;
import com.dynagility.leavingtoolportal.model.Account;

@Repository
@Transactional
public class EmployeeDetailDaoImpl implements EmployeeDetailDao {
	    private EntityManager entityManager;
	    @Autowired
	    private AccountDao accountRepository;
	 
	    public EmployeeDetailVO getUserDetailByAccountName(String username) {
	        Account account =  accountRepository.findById(username);
	        EmployeeDetailVO empl = new EmployeeDetailVO(account.getEmployee());
	        empl.setRole_id(account.getRole().getId());
	        empl.setRole_name(account.getRole().getName());
	        return empl;
	    }
	    
}
