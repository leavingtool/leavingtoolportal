package com.dynagility.leavingtoolportal.Dao;

import com.dynagility.leavingtoolportal.model.Account;

public interface AccountDao {
	public Account findByUsername(String username);
}
