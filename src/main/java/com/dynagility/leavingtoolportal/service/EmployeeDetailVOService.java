package com.dynagility.leavingtoolportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynagility.leavingtoolportal.Dao.EmployeeDetailDao;
import com.dynagility.leavingtoolportal.VO.EmployeeDetailVO;
import com.dynagility.leavingtoolportal.VO.EmployeeProjectVO;
import com.dynagility.leavingtoolportal.model.EmployeeProject;
@Service
public class EmployeeDetailVOService {
    @Autowired
    private EmployeeDetailDao employeeDetailRepository;
    @Autowired
    private ProjectService projectService;
    
    public EmployeeDetailVO getUserDetailByAccountName(String _accountName) {
        return employeeDetailRepository.getUserDetailByAccountName(_accountName);
    }
    public EmployeeDetailVO getUserDetailByAccountId(String _accountId) {
    	return employeeDetailRepository.getUserDetailByAccountId(_accountId);
    }
    
    public EmployeeDetailVO getUserDetailEmployeeId(String _employeeId) {

    	EmployeeDetailVO employeeDetailVO = employeeDetailRepository.getUserDetailByEmployeeId(_employeeId);
    	List<EmployeeProjectVO> list_employeeProjectVO = projectService.getEmp_Pro_ByEmployeeId(_employeeId);
    	List<String> list_Project_Id = new ArrayList<String>();
    	List<String> list_Project_Name = new ArrayList<String>();
    	for(EmployeeProjectVO e: list_employeeProjectVO){
    		list_Project_Id.add(e.getProject().getId());
			list_Project_Name.add(e.getProject().getName());
		}
//		employeeDetailVO.setProject_id(list_Project_Id);
//		employeeDetailVO.setProject_name(list_Project_Name);
		
    	return employeeDetailVO;
    }
}
