package com.dynagility.leavingtoolportal.Dao;

import com.dynagility.leavingtoolportal.VO.EmployeeDetailVO;

public interface EmployeeDetailDao {
	public EmployeeDetailVO getUserDetailByAccountName(String accountName);
	public EmployeeDetailVO getUserDetailByAccountId(String accountId);
	public EmployeeDetailVO getUserDetailByEmployeeId(String employeeId);
}
