package com.dynagility.leavingtoolportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynagility.leavingtoolportal.Dao.EmployeeDetailDao;
import com.dynagility.leavingtoolportal.VO.EmployeeDetailVO;
@Service
public class EmployeeDetailVOService {
    @Autowired
    private EmployeeDetailDao employeeDetailRepository;
    
    public EmployeeDetailVO getUserDetailByAccountName(String _accountName) {
        return employeeDetailRepository.getUserDetailByAccountName(_accountName);
    }
}
