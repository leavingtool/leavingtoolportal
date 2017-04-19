package com.dynagility.leavingtoolportal.model;

import com.dynagility.leavingtoolportal.object_value.EmployeeVO;

public class EmployeeMapper {

    public static EmployeeVO updateEmployeeVO(Employee source) {
    	EmployeeVO employee = new EmployeeVO();
        employee.setId(source.getId() != null ? source.getId() : employee.getId());
        employee.setName(source.getName() != null ? source.getName() : employee.getName());
        employee.setEmail(source.getEmail() != null ? source.getEmail() : employee.getEmail());
        employee.setBalanceDay(source.getBalanceDay() != null ? source.getBalanceDay() : employee.getBalanceDay());
        employee.setDeductedDay(source.getDeductedDay() != null ? source.getDeductedDay() : employee.getDeductedDay());
        employee.setPositionId(source.getPositionId() != null ? source.getPositionId() : employee.getPositionId());
        employee.setJoinDate(source.getJoinDate() != null ? source.getJoinDate() : employee.getJoinDate());

        return employee;
    }

    public static Employee updateEmployee(EmployeeVO source, Employee employee) {
        employee.setName(source.getName() != null ? source.getName() : employee.getName());
        employee.setEmail(source.getEmail() != null ? source.getEmail() : employee.getEmail());
        employee.setBalanceDay(source.getBalanceDay() != null ? source.getBalanceDay() : employee.getBalanceDay());
        employee.setDeductedDay(source.getDeductedDay() != null ? source.getDeductedDay() : employee.getDeductedDay());
        employee.setPositionId(source.getPositionId() != null ? source.getPositionId() : employee.getPositionId());
        employee.setJoinDate(source.getJoinDate() != null ? source.getJoinDate() : employee.getJoinDate());

        return employee;
    }

}
