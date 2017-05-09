package com.dynagility.leavingtoolportal.DaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dynagility.leavingtoolportal.Dao.AccountDao;
import com.dynagility.leavingtoolportal.VO.AccountVO;
import com.dynagility.leavingtoolportal.VO.LoginVO;
import com.dynagility.leavingtoolportal.exceptions.NotFoundException;
import com.dynagility.leavingtoolportal.model.Account;
import com.dynagility.leavingtoolportal.model.mapper.RoleMapper;

@Repository
@Transactional
public class AccountDaoImpl implements AccountDao {
	@PersistenceContext 
    private EntityManager entityManager;
	private RoleMapper roleMapper;
    @SuppressWarnings("unchecked")
    @Override
    public AccountVO findByUserName(String username) {
        String hql = "select ac from Account ac where username =:username";
        Account account = null;
        account =  (Account) entityManager.createQuery(hql).setParameter("username", username).getSingleResult();
        AccountVO accountVO = new AccountVO(account.getId(), account.getUsername(), account.getEmployee(), account.getRole());
        return accountVO;
    }
    
    public AccountVO findById(String id) {
        String hql = "select ac from Account ac where id =:id";
        Account account = null;
        account =  (Account) entityManager.createQuery(hql).setParameter("id", id).getSingleResult();
        AccountVO accountVO = new AccountVO(account.getId(), account.getUsername(), account.getEmployee(), account.getRole());
        return accountVO;
    }

	@Override
	public AccountVO findByEmployeeId(String employee_Id) {
		String hql = "select ac from Account ac where employee_id =:employee_id";
        Account account = null;
        account =  (Account) entityManager.createQuery(hql).setParameter("employee_id", employee_Id).getSingleResult();
        System.out.println(account.getUsername());
        AccountVO accountVO = new AccountVO(account.getId(), account.getUsername(), account.getEmployee(), account.getRole());
        return accountVO;
	}
	
	@Override
	public LoginVO checkLogin(Account account) {
        try {
        	String hql = "select ac from Account ac where username =:username";
            Account _account = null;
            _account =  (Account) entityManager.createQuery(hql).setParameter("username", account.getUsername()).getSingleResult();
        	
            LoginVO loginVO = new LoginVO();
        	boolean flags = _account.getPassword().equalsIgnoreCase(account.getPassword());
        	if (flags == true) {
        		loginVO.setId(_account.getEmployee().getId());
        		loginVO.setRole(roleMapper.updateRoleVO(_account.getRole()));
        		loginVO.setStatus(flags);
                return loginVO;
        	}
        	else {
        		return loginVO;
        	}
        }
        catch (Exception e) {
            throw new NotFoundException("Cannot Login");
        }
    }

}
