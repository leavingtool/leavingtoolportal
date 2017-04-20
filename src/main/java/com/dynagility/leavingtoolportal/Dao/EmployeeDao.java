package com.dynagility.leavingtoolportal.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.object_value.EmployeeVO;

@Component
public interface EmployeeDao {

    public List<EmployeeVO> findAll();

    public EmployeeVO findEmployeeById (String id);

    public EmployeeVO save(EmployeeVO employeeVO);

    public void delete(String id);
}
