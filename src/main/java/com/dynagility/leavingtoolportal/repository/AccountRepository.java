package com.dynagility.leavingtoolportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dynagility.leavingtoolportal.model.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, String>{
	 public Account findByUsername(String username);
}
