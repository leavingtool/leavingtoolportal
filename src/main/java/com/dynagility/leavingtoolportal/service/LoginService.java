package com.dynagility.leavingtoolportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynagility.leavingtoolportal.Dao.AccountDao;
import com.dynagility.leavingtoolportal.VO.LoginVO;
import com.dynagility.leavingtoolportal.model.Account;

@Service
public class LoginService {
	@Autowired
    private AccountDao accountDao;
	
	public LoginVO checkLogin(Account account) {
    	return accountDao.checkLogin(account);
    }

}
