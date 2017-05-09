package com.dynagility.leavingtoolportal.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dynagility.leavingtoolportal.VO.AccountVO;
import com.dynagility.leavingtoolportal.VO.EmployeeVO;
import com.dynagility.leavingtoolportal.model.Employee;

@Component
public interface EmployeeDao {

    public List<EmployeeVO> findAll();

    public EmployeeVO findEmployeeById (String id);
    
    public EmployeeVO findEmployeeByEmployeeId (String employee_Id);

    public EmployeeVO save(EmployeeVO employeeVO);

    public void delete(String id);
}
