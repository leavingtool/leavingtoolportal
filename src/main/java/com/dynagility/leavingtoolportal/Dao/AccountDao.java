package com.dynagility.leavingtoolportal.Dao;

import org.springframework.stereotype.Component;

import com.dynagility.leavingtoolportal.model.Account;

@Component
public interface AccountDao {

    public Account findByUserName (String username);
    public Account findById (String id);
    public Account findByEmployeeId (String employeeId);
}
