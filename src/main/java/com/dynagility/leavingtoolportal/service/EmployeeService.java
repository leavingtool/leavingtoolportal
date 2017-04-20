package com.dynagility.leavingtoolportal.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

            return employeeDao.save(newEmployeeVO);
        }
        catch (Exception e) {
            throw new InternalErrorException(e.getMessage());
        }
    }

    public EmployeeVO getEmployeeById(String id) {
        try {
            EmployeeVO emVo = employeeDao.findEmployeeById(id);
            return emVo;
        }
        catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Employee is not there");
        }
        catch (Exception ex) {
            throw new InternalErrorException(ex.getMessage());
        }
    }

    public void deleteEmployeeById(String id) {
        try {
            employeeDao.delete(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Employee is not there");
        }
        catch (Exception ex) {
            throw new InternalErrorException(ex.getMessage());
        }
    }

    public EmployeeVO updateEmployee(EmployeeVO employeeVO) {
        try {
            EmployeeVO emVo = employeeDao.save(employeeVO);
            return emVo;
        }
        catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Employee is not there");
        }
        catch (Exception ex) {
            throw new InternalErrorException(ex.getMessage());
        }
    }
}
