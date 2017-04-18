package com.dynagility.leavingtoolportal.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dynagility.leavingtoolportal.model.Employee;

@Component
public interface EmployeeDao {

    public List<Employee> findAll();

    public Employee findById (String id);

    public void save(Employee employee);

    public void delete(Employee employee);
}