package com.dynagility.leavingtoolportal.object_value;

import com.dynagility.leavingtoolportal.model.Employee;

public class EmployeeVO extends Employee{

    public EmployeeVO() {
        super();
        // TODO Auto-generated constructor stub
    }
    public EmployeeVO(Employee source) {
        super();
        this.update(source);
    }
}
