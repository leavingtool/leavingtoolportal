package com.dynagility.leavingtoolportal.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynagility.leavingtoolportal.Dao.EmployeeDao;
import com.dynagility.leavingtoolportal.exceptions.InternalErrorException;
import com.dynagility.leavingtoolportal.exceptions.NotFoundException;
import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.object_value.EmployeeVO;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeRepository;

    public List<EmployeeVO> getAll() {
        List<EmployeeVO> employeeVOs= employeeRepository.findAll();

        return employeeVOs;
    }

    public EmployeeVO addEmployee(EmployeeVO newEmployeeVO) {
        try {
            newEmployeeVO.setId(null);
            newEmployeeVO.setJoinDate(new Date());
            employeeRepository.save(newEmployeeVO);
            return employeeRepository.findById(newEmployeeVO.getId());
        }
        catch (Exception e) {
            throw new InternalErrorException(e.getMessage());
        }
    }

    public EmployeeVO getEmployeeById(String id) {
        if (id == null) {
            return null;
        }

        return employeeRepository.findById(id);
    }

    public boolean deleteEmployeeById(String id) {
        try {
            EmployeeVO employeeVO = employeeRepository.findById(id);

            if (employeeVO != null) {
                employeeRepository.delete(employeeVO);
                return true;
            }
        }
        catch (Exception e) {
            throw new NotFoundException("Employee is not there");
        }
 
        return false;
    }

    public EmployeeVO updateEmployee(EmployeeVO employeeVO) {
        EmployeeVO updateEmployee = employeeRepository.findById(employeeVO.getId());

        if (updateEmployee == null) {
            return null;
        }

        updateEmployee.update(employeeVO);
        employeeRepository.save(updateEmployee);

        return updateEmployee;
    }
}
