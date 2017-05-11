package com.dynagility.leavingtoolportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynagility.leavingtoolportal.Dao.EmployeeDao;
import com.dynagility.leavingtoolportal.Dao.Employee_ProjectDao;
import com.dynagility.leavingtoolportal.Dao.ProgramDao;
import com.dynagility.leavingtoolportal.VO.AvailableApproverVO;
import com.dynagility.leavingtoolportal.VO.EmployeeVO;
import com.dynagility.leavingtoolportal.VO.Employee_ProjectVO;
import com.dynagility.leavingtoolportal.VO.ProjectVO;
import com.dynagility.leavingtoolportal.model.mapper.EmployeeMapper;

@Service
public class AvailableApproverService {
	@Autowired
    private ProgramDao programDao;
	@Autowired
    private Employee_ProjectDao employee_ProjectDao;
	@Autowired
    private EmployeeDao employeeDao;
    
	
	public AvailableApproverVO getAvailableApprover(String employee_id){
		AvailableApproverVO availableApproverVO = new AvailableApproverVO();
		List<Employee_ProjectVO>listEmployee_Project = employee_ProjectDao.getEm_PojectByEmployeeId(employee_id);
		List<EmployeeVO>list_pm = new ArrayList<>();
		List<EmployeeVO>list_director = new ArrayList<>();
		List<EmployeeVO>list_smpc = new ArrayList<>();
		
		for (Employee_ProjectVO eVO : listEmployee_Project){
			String pm_id = eVO.getProject().getPm_Employee().getId();
			EmployeeVO pm = employeeDao.findEmployeeByEmployeeId(pm_id);
			list_pm.add(pm);
			
			
			list_smpc.add(eVO.getProject().getProgram().getSm_pc());
			list_director.add(eVO.getProject().getProgram().getDc().getDirector());
		}
		availableApproverVO.setPm(list_pm);
		availableApproverVO.setSm_pc(list_smpc);
		availableApproverVO.setDirector(list_director);
		return availableApproverVO;
	}
}
