package com.dynagility.leavingtoolportal.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dynagility.leavingtoolportal.Dao.EmployeeDao;
import com.dynagility.leavingtoolportal.Dao.LeaveDetailDao;
import com.dynagility.leavingtoolportal.VO.EmployeeVO;
import com.dynagility.leavingtoolportal.VO.Employee_ProjectVO;
import com.dynagility.leavingtoolportal.VO.LeaveDetailVO;
import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.model.EmployeeProject;
import com.dynagility.leavingtoolportal.model.LeaveDetail;
import com.dynagility.leavingtoolportal.model.mapper.EmployeeMapper;
import com.dynagility.leavingtoolportal.model.mapper.LeaveDetailMapper;

@Repository
@Transactional
public class LeaveDetailDaoImpl implements LeaveDetailDao {
	@PersistenceContext 
    private EntityManager entityManager;
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<LeaveDetailVO> getAllLeaveDetailVO() {
		String hql = "from LeaveDetail";
        List<LeaveDetail> leaveDetails = null;
        leaveDetails = entityManager.createQuery(hql).getResultList();

        List<LeaveDetailVO> leaveDetailVos = new ArrayList<LeaveDetailVO>();
        for(LeaveDetail e : leaveDetails) {
        	leaveDetailVos.add(LeaveDetailMapper.updateLeaveDetailVO(e));
        }
        return leaveDetailVos;
	}

	@Override
	public List<LeaveDetailVO> getLeaveDetailVOByEmployeeId(String id) {
		String hql = "select pro from LeaveDetail pro where employee_id =:emloyeeId";
		List<LeaveDetailVO> leaveDetailVOs = new ArrayList<>();
		List<LeaveDetail> leaveDetails = null;
		
		leaveDetails =  (List<LeaveDetail>) entityManager.createQuery(hql).setParameter("emloyeeId", id).getResultList();
		for(LeaveDetail e : leaveDetails){
			LeaveDetailVO leaveVO = LeaveDetailMapper.updateLeaveDetailVO(e);
			List<EmployeeVO> employeeVOs = new ArrayList<>();
			String x = e.getApprover();
			String []ar = x.split(", ");
			for (String i : ar) {
				EmployeeVO empVO = employeeDao.findEmployeeByEmployeeId(i);
				employeeVOs.add(empVO);
			}
			leaveVO.setApprovers(employeeVOs);
			leaveDetailVOs.add(leaveVO);
    	}
		return leaveDetailVOs;
	}

}
