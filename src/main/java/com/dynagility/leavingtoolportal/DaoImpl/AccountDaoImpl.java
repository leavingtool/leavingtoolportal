package com.dynagility.leavingtoolportal.DaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dynagility.leavingtoolportal.Dao.AccountDao;
import com.dynagility.leavingtoolportal.VO.AccountVO;
import com.dynagility.leavingtoolportal.VO.EmployeeVO;
import com.dynagility.leavingtoolportal.VO.LoginVO;
import com.dynagility.leavingtoolportal.VO.RoleVO;
import com.dynagility.leavingtoolportal.exceptions.NotFoundException;
import com.dynagility.leavingtoolportal.model.Account;
import com.dynagility.leavingtoolportal.model.mapper.EmployeeMapper;
import com.dynagility.leavingtoolportal.model.mapper.RoleMapper;

@Repository
@Transactional
public class AccountDaoImpl implements AccountDao {
	@PersistenceContext 
    private EntityManager entityManager;
	private RoleMapper roleMapper;
	private EmployeeMapper employeeMapper;
	
    @SuppressWarnings("unchecked")
    @Override
    public AccountVO findByUserName(String username) {
        String hql = "select ac from Account ac where username =:username";
        Account account = null;
        account =  (Account) entityManager.createQuery(hql).setParameter("username", username).getSingleResult();
        RoleVO roleVO = roleMapper.updateRoleVO(account.getRole());
        EmployeeVO empVO = employeeMapper.updateEmployeeVO(account.getEmployee());
        AccountVO accountVO = new AccountVO(account.getId(), account.getUsername(), empVO, roleVO);
        return accountVO;
    }
    
    public AccountVO findById(String id) {
        String hql = "select ac from Account ac where id =:id";
        Account account = null;
        account =  (Account) entityManager.createQuery(hql).setParameter("id", id).getSingleResult();
        RoleVO roleVO = roleMapper.updateRoleVO(account.getRole());
        EmployeeVO empVO = employeeMapper.updateEmployeeVO(account.getEmployee());
        AccountVO accountVO = new AccountVO(account.getId(), account.getUsername(), empVO, roleVO);
        return accountVO;
    }

	@Override
	public AccountVO findByEmployeeId(String employeeId) {
		String hql = "select ac from Account ac where employee_id =:employee_id";
        Account account = null;
        account =  (Account) entityManager.createQuery(hql).setParameter("employee_id", employeeId).getSingleResult();
        RoleVO roleVO = roleMapper.updateRoleVO(account.getRole());
        EmployeeVO empVO = employeeMapper.updateEmployeeVO(account.getEmployee());
        AccountVO accountVO = new AccountVO(account.getId(), account.getUsername(), empVO, roleVO);
        return accountVO;
	}
	
	@Override
	public LoginVO checkLogin(Account account) {
        try {
        	String hql = "select ac from Account ac where username =:username";
            Account checkAccount = null;
            checkAccount =  (Account) entityManager.createQuery(hql).setParameter("username", account.getUsername()).getSingleResult();
        	
            LoginVO loginVO = new LoginVO();
        	boolean flags = checkAccount.getPassword().equalsIgnoreCase(account.getPassword());
        	if (flags == true) {
        		loginVO.setId(checkAccount.getEmployee().getId());
        		loginVO.setName(checkAccount.getEmployee().getName());
        		loginVO.setRole(roleMapper.updateRoleVO(checkAccount.getRole()));
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
