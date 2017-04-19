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
    private EmployeeDao employeeDao;

    public List<EmployeeVO> getAll() {
        List<EmployeeVO> employeeVOs= employeeDao.findAll();

        return employeeVOs;
    }

    public EmployeeVO addEmployee(EmployeeVO newEmployeeVO) {
        try {
            newEmployeeVO.setId(null);
            newEmployeeVO.setJoinDate(new Date());
            employeeDao.save(newEmployeeVO);
            return employeeDao.findEmployeeByEmail(newEmployeeVO.getEmail());
        }
        catch (Exception e) {
            throw new InternalErrorException(e.getMessage());
        }
    }

    public EmployeeVO getEmployeeById(String id) {
        if (id == null) {
            return null;
        }

        return employeeDao.findEmployeeById(id);
    }

    public boolean deleteEmployeeById(String id) {
        try {
            EmployeeVO employeeVO = employeeDao.findEmployeeById(id);

            if (employeeVO != null) {
                employeeDao.delete(employeeVO);
                return true;
            }
        }
        catch (Exception e) {
            throw new NotFoundException("Employee is not there");
        }
 
        return false;
    }

    public EmployeeVO updateEmployee(EmployeeVO employeeVO) {

        employeeDao.save(employeeVO);

        return employeeVO;
    }
}
