package com.dynagility.leavingtoolportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynagility.leavingtoolportal.Dao.AccountDao;
import com.dynagility.leavingtoolportal.VO.AccountVO;

@Service
public class AccountService {
	@Autowired
    private AccountDao accountDao;
	
	public AccountVO findByUserName(String userName){
		return accountDao.findByUserName(userName);
	}

}
