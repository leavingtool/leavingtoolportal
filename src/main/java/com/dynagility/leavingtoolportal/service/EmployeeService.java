package com.dynagility.leavingtoolportal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynagility.leavingtoolportal.exceptions.InternalErrorException;
import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.repository.EmployeeRepository;

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
            newEmployee.setJoinDate(new Date());
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

    public boolean deleteEmployeeById(String id) {
        Employee employee = employeeRepository.findOne(id);
        if (employee == null) {
            return false;
        }

        if (employee != null) {
            employeeRepository.delete(employee);
            return true;
        }

        return false;
    }
}
