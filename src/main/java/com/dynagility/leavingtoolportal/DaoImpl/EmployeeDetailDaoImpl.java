package com.dynagility.leavingtoolportal.DaoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dynagility.leavingtoolportal.Dao.AccountDao;
import com.dynagility.leavingtoolportal.Dao.EmployeeDao;
import com.dynagility.leavingtoolportal.Dao.EmployeeDetailDao;
import com.dynagility.leavingtoolportal.VO.EmployeeDetailVO;
import com.dynagility.leavingtoolportal.VO.EmployeeProjectVO;
import com.dynagility.leavingtoolportal.model.Account;
import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.service.ProjectService;

@Repository
@Transactional
public class EmployeeDetailDaoImpl implements EmployeeDetailDao {
	    private EntityManager entityManager;
	    @Autowired
	    private AccountDao accountRepository;
	    @Autowired
	    private EmployeeDao employeeRepository;
	 
	    public EmployeeDetailVO getUserDetailByAccountName(String username) {
	        Account account =  accountRepository.findByUserName(username);
	        EmployeeDetailVO empl = new EmployeeDetailVO(account.getEmployee());
	        empl.setRole_id(account.getRole().getId());
	        empl.setRole_name(account.getRole().getName());
	        return empl;
	    }
	    
	    public EmployeeDetailVO getUserDetailByAccountId(String id) {
	        Account account =  accountRepository.findById(id);
	        EmployeeDetailVO empl = new EmployeeDetailVO(account.getEmployee());
	        empl.setRole_id(account.getRole().getId());
	        empl.setRole_name(account.getRole().getName());
	        return empl;
	    }

		@Override
		public EmployeeDetailVO getUserDetailByEmployeeId(String employee_Id) {
			Account account =  accountRepository.findByEmployeeId(employee_Id);
			EmployeeDetailVO employeeDetailVO = new EmployeeDetailVO(account.getEmployee());
			employeeDetailVO.setRole_id(account.getRole().getId());
			employeeDetailVO.setRole_name(account.getRole().getName());
			return employeeDetailVO;
		}
}
