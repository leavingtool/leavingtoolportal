package com.dynagility.leavingtoolportal.VO;

import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.model.EmployeeProject;

public class EmployeeProjectVO extends EmployeeProject {

	public EmployeeProjectVO() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public EmployeeProjectVO(EmployeeProject emp_Pro) {
        super();
        this.update(emp_Pro);
    }
}
