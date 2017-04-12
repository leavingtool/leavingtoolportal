package com.dynagility.leavingtoolportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dynagility.leavingtoolportal.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
