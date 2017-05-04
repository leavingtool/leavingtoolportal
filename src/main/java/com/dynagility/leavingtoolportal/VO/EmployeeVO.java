package com.dynagility.leavingtoolportal.VO;

import com.dynagility.leavingtoolportal.model.Employee;

public class EmployeeVO extends Employee {

    public EmployeeVO() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public EmployeeVO(Employee _employee) {
        super();
        this.update(_employee);
    }
}
