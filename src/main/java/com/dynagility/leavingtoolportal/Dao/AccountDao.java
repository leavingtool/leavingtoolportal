package com.dynagility.leavingtoolportal.Dao;

import org.springframework.stereotype.Component;

import com.dynagility.leavingtoolportal.VO.AccountVO;
import com.dynagility.leavingtoolportal.VO.LoginVO;
import com.dynagility.leavingtoolportal.model.Account;

@Component
public interface AccountDao {
	public AccountVO findByUserName (String username);
    public AccountVO findById (String id);
    public AccountVO findByEmployeeId (String employeeId);
    public LoginVO checkLogin(Account account);
}
