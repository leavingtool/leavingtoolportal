package com.dynagility.leavingtoolportal.model.mapper;

import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.object_value.EmployeeVO;

public class EmployeeMapper {

    public static EmployeeVO updateEmployeeVO(Employee source) {
        EmployeeVO employeeVo = new EmployeeVO();
        employeeVo.setId(source.getId() != null ? source.getId() : employeeVo.getId());
        employeeVo.setName(source.getName() != null ? source.getName() : employeeVo.getName());
        employeeVo.setEmail(source.getEmail() != null ? source.getEmail() : employeeVo.getEmail());
        employeeVo.setBalanceDay(source.getBalanceDay() != null ? source.getBalanceDay() : employeeVo.getBalanceDay());
        employeeVo.setDeductedDay(source.getDeductedDay() != null ? source.getDeductedDay() : employeeVo.getDeductedDay());
        employeeVo.setPosition(source.getPosition() != null ? source.getPosition() : employeeVo.getPosition());
        employeeVo.setJoinDate(source.getJoinDate() != null ? source.getJoinDate() : employeeVo.getJoinDate());

        return employeeVo;
    }

    public static Employee updateEmployee(EmployeeVO source, Employee employee) {
        employee.setName(source.getName() != null ? source.getName() : employee.getName());
        employee.setEmail(source.getEmail() != null ? source.getEmail() : employee.getEmail());
        employee.setBalanceDay(source.getBalanceDay() != null ? source.getBalanceDay() : employee.getBalanceDay());
        employee.setDeductedDay(source.getDeductedDay() != null ? source.getDeductedDay() : employee.getDeductedDay());
        employee.setPosition(source.getPosition() != null ? source.getPosition() : employee.getPosition());
        employee.setJoinDate(source.getJoinDate() != null ? source.getJoinDate() : employee.getJoinDate());

        return employee;
    }

}
