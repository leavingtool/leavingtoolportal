package com.dynagility.leavingtoolportal.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynagility.leavingtoolportal.Dao.AccountDao;
import com.dynagility.leavingtoolportal.Dao.EmployeeDao;
import com.dynagility.leavingtoolportal.VO.EmployeeVO;
import com.dynagility.leavingtoolportal.exceptions.InternalErrorException;
import com.dynagility.leavingtoolportal.exceptions.NotFoundException;
import com.dynagility.leavingtoolportal.model.Account;
import com.dynagility.leavingtoolportal.model.Employee;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeRepository;
    @Autowired
    private AccountDao accountRepository;

    public List<EmployeeVO> getAll() {
        List<Employee> employees= (List<Employee>) employeeRepository.findAll();
        List<EmployeeVO> employeeVOs = new  ArrayList<EmployeeVO>();
        for(Employee e : employees) {
            EmployeeVO eVO = new EmployeeVO(e);
            eVO.setId(e.getId());
            employeeVOs.add(eVO);
        }
        return employeeVOs;
    }
   
    public Employee addEmployee(Employee newEmployee) {
        try {
            newEmployee.setId(null);
            newEmployee.setJoinDate(new Date());
             employeeRepository.save(newEmployee);
             return employeeRepository.findById(newEmployee.getId());
        }
        catch (Exception e) {
            throw new InternalErrorException(e.getMessage());
        }
    }

    public Employee getEmployeeById(String id) {
        if (id == null) {
            return null;
        }

        return employeeRepository.findById(id);
    }

    public boolean deleteEmployeeById(String id) {
        try {
            Employee employee = employeeRepository.findById(id);

            if (employee != null) {
                employeeRepository.delete(employee);
                return true;
            }
        }
        catch (Exception e) {
            throw new NotFoundException("Employee is not there");
        }
 
        return false;
    }

    public Employee updateEmployee(Employee employee) {
        Employee updateEmployee = employeeRepository.findById(employee.getId());

        if (updateEmployee == null) {
            return null;
        }

        updateEmployee.update(employee);
        employeeRepository.save(updateEmployee);

        return updateEmployee;
    }

    public boolean checkLogin(Account account) {
        try {
        	Account checkAccount = accountRepository.findById(account.getUsername());
        	
        	boolean flags = checkAccount.getPassword().equalsIgnoreCase(account.getPassword());
        	if (flags == true) {
                return true;
        	}
        	else {
        		return false;
        	}
        }
        catch (Exception e) {
            throw new NotFoundException("Cannot Login");
        }
    }
}
