package com.dynagility.leavingtoolportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynagility.leavingtoolportal.Dao.EmployeeDao;
import com.dynagility.leavingtoolportal.Dao.EmployeeProjectDao;
import com.dynagility.leavingtoolportal.Dao.ProgramDao;
import com.dynagility.leavingtoolportal.VO.AvailableApproverVO;
import com.dynagility.leavingtoolportal.VO.EmployeeVO;
import com.dynagility.leavingtoolportal.VO.EmployeeProjectVO;
import com.dynagility.leavingtoolportal.VO.ProjectVO;
import com.dynagility.leavingtoolportal.model.mapper.EmployeeMapper;

@Service
public class AvailableApproverService {
	@Autowired
    private ProgramDao programDao;
	@Autowired
    private EmployeeProjectDao employeeProjectDao;
	@Autowired
    private EmployeeDao employeeDao;
    
	
	public AvailableApproverVO getAvailableApprover(String employeeId){
		AvailableApproverVO availableApproverVO = new AvailableApproverVO();
		List<EmployeeProjectVO>listEmployee_Project = employeeProjectDao.getEmProjectByEmployeeId(employeeId);
		
		
		List<EmployeeVO>approvers = new ArrayList<>();
		
		for (EmployeeProjectVO eVO : listEmployee_Project){
			
			EmployeeVO pm = eVO.getProject().getPm_Employee();
			EmployeeVO smPC = eVO.getProject().getProgram().getSm_pc();
			EmployeeVO director = eVO.getProject().getProgram().getDc().getDirector();
			if (pm != null){
				approvers.add(pm);
			}
			if (smPC != null){
				approvers.add(smPC);
			}
			if (director != null){
				approvers.add(director);
			}
			
		}
		availableApproverVO.setData(approvers);
		return availableApproverVO;
	}
}
