package com.dynagility.leavingtoolportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.model.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, String>{
	
}
