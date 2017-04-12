package com.dynagility.leavingtoolportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynagility.leavingtoolportal.exceptions.InternalErrorException;
import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.repository.EmployeeRepository;
import com.dynagility.leavingtoolportal.util.DateTimeUtil;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee addEmployee(Employee newEmployee) {
        try {
            newEmployee.setId(null);
            newEmployee.setJoinDate(DateTimeUtil.currentDateTimeUTC());
            return employeeRepository.save(newEmployee);
        }
        catch (Exception e) {
            throw new InternalErrorException(e.getMessage());
        }
    }

    public Employee getEmployeeById(String id) {

        if (id == null) {
            return null;
        }

        return employeeRepository.findOne(id);
    }
}
