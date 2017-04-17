package com.dynagility.leavingtoolportal.schedules;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.repository.EmployeeRepository;

@Component
public class ScheduleTasks {
    @Autowired
    EmployeeRepository employeeRepository;
    @Scheduled(cron = "0 0 0 15 * ?")
    public void scheduleTasks() {
        List<Employee> employees = employeeRepository.findAll();
        for(Employee e : employees ) {
            e.setBalanceDay(e.getBalanceDay()+1);
            employeeRepository.save(e);
        }
    }
}
