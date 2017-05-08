package com.dynagility.leavingtoolportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynagility.leavingtoolportal.Dao.AccountDao;
import com.dynagility.leavingtoolportal.Dao.EmployeeProjectDao;
import com.dynagility.leavingtoolportal.VO.EmployeeProjectVO;
import com.dynagility.leavingtoolportal.model.Account;
import com.dynagility.leavingtoolportal.model.EmployeeProject;

@Service
public class ProjectService {
	@Autowired
    private EmployeeProjectDao emp_Pro_Repository;

	public List<EmployeeProjectVO> getEmp_Pro_ByEmployeeId(String employee_id) {
		List<EmployeeProjectVO> list_emp_vo = new ArrayList<EmployeeProjectVO>();
		List<EmployeeProject> list_emp_pro = emp_Pro_Repository.getEm_PojectByEmployeeId(employee_id);
		for(EmployeeProject e: list_emp_pro){
			EmployeeProjectVO emp_vo = new EmployeeProjectVO(e);
			list_emp_vo.add(emp_vo);
		}
        return list_emp_vo;
    }
	
	public List<EmployeeProject> getAll_Emp_Pro_By(String employee_id) {
        if (employee_id == null) {
            return null;
        }

        return emp_Pro_Repository.getAllEm_Project();
    }
}
