package com.dynagility.leavingtoolportal.model.mapper;

import com.dynagility.leavingtoolportal.VO.EmployeeVO;
import com.dynagility.leavingtoolportal.model.Employee;

public class EmployeeMapper {

    public static EmployeeVO updateEmployeeVO(Employee source) {
        EmployeeVO employeeVo = new EmployeeVO();
        employeeVo.setId(source.getId() != null ? source.getId() : employeeVo.getId());
        employeeVo.setName(source.getName() != null ? source.getName() : employeeVo.getName());
        employeeVo.setEmail(source.getEmail() != null ? source.getEmail() : employeeVo.getEmail());
        employeeVo.setBalance_day(source.getBalanceDay() != null ? source.getBalanceDay() : employeeVo.getBalance_day());
        employeeVo.setDeducted_day(source.getDeductedDay() != null ? source.getDeductedDay() : employeeVo.getDeducted_day());
        employeeVo.setJoin_date(source.getJoinDate() != null ? source.getJoinDate() : employeeVo.getJoin_date());

        return employeeVo;
    }

    public static Employee updateEmployee(EmployeeVO source, Employee employee) {
        employee.setName(source.getName() != null ? source.getName() : employee.getName());
        employee.setEmail(source.getEmail() != null ? source.getEmail() : employee.getEmail());
        employee.setBalanceDay(source.getBalance_day() != null ? source.getBalance_day() : employee.getBalanceDay());
        employee.setDeductedDay(source.getDeducted_day() != null ? source.getDeducted_day() : employee.getDeductedDay());
        employee.setJoinDate(source.getJoin_date() != null ? source.getJoin_date() : employee.getJoinDate());

        return employee;
    }

}
