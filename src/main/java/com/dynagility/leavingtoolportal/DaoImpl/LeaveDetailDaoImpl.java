package com.dynagility.leavingtoolportal.DaoImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dynagility.leavingtoolportal.Dao.AccountDao;
import com.dynagility.leavingtoolportal.Dao.EmployeeDao;
import com.dynagility.leavingtoolportal.Dao.LeaveDetailDao;
import com.dynagility.leavingtoolportal.VO.AccountVO;
import com.dynagility.leavingtoolportal.VO.ApproverDetailVO;
import com.dynagility.leavingtoolportal.VO.EmployeeVO;
import com.dynagility.leavingtoolportal.VO.EmployeeProjectVO;
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
	@Autowired
	private AccountDao accountDao;

	@Override
	public List<LeaveDetailVO> getAllLeaveDetailVO() {
		String hql = "from LeaveDetail";
		List<LeaveDetail> leaveDetails = null;
		leaveDetails = entityManager.createQuery(hql).getResultList();

		List<LeaveDetailVO> leaveDetailVos = new ArrayList<LeaveDetailVO>();
		for (LeaveDetail e : leaveDetails) {
			leaveDetailVos.add(LeaveDetailMapper.updateLeaveDetailVO(e));
		}
		return leaveDetailVos;
	}

	@Override
	public List<LeaveDetailVO> getLeaveDetailVOByEmployeeId(String id) {
		String hql = "select pro from LeaveDetail pro where employee_id =:employeeId";
		List<LeaveDetailVO> leaveDetailVOs = new ArrayList<>();
		List<LeaveDetail> leaveDetails = null;

		leaveDetails = (List<LeaveDetail>) entityManager.createQuery(hql).setParameter("employeeId", id)
				.getResultList();
		for (LeaveDetail e : leaveDetails) {
			LeaveDetailVO leaveVO = LeaveDetailMapper.updateLeaveDetailVO(e);
			List<EmployeeVO> employeeVOs = new ArrayList<>();
			List<ApproverDetailVO> listApprovers = new ArrayList<>();
			String x = e.getApprover();
			String[] ar = x.split(", ");
			for (String i : ar) {
				AccountVO accountVO = accountDao.findByEmployeeId(i);
				ApproverDetailVO approver = new ApproverDetailVO();
				EmployeeVO empVO = employeeDao.findEmployeeByEmployeeId(i);
				approver.setId(empVO.getId());
				approver.setUsername(accountVO.getUsername());
				approver.setPosition_name(empVO.getPosition_name());
				approver.setProjects(empVO.getProjects());
				approver.setRole(empVO.getRole());
				approver.setName(empVO.getName());
				employeeVOs.add(empVO);
				listApprovers.add(approver);
			}
			leaveVO.setApprovers(listApprovers);
			leaveDetailVOs.add(leaveVO);
		}
		return leaveDetailVOs;
	}

	@Override
	public List<LeaveDetailVO> getEmployeeLeaveDetailVOByReasonAndYear(String employeeId, String reasonId, int year) {
		String hql = "select ld from LeaveDetail ld where employee_id =:employee_id and reason_id =:reason_id and YEAR(leave_to) =:year";
		List<LeaveDetailVO> leaveDetailVOs = new ArrayList<>();
		List<LeaveDetail> leaveDetails = null;
		leaveDetails = (List<LeaveDetail>) entityManager.createQuery(hql).setParameter("employee_id", employeeId)
				.setParameter("reason_id", reasonId).setParameter("year", year).getResultList();
		for (LeaveDetail e : leaveDetails) {
			LeaveDetailVO leaveVO = LeaveDetailMapper.updateLeaveDetailVO(e);
			leaveDetailVOs.add(leaveVO);
		}

		return leaveDetailVOs;
	}

	public LeaveDetail findById(String id) {
		String hql = "select e from Employee e where id =:id";
		LeaveDetail leaveDetail = null;
		leaveDetail = (LeaveDetail) entityManager.createQuery(hql).setParameter("id", id).getSingleResult();
		return leaveDetail;
	}

	@Override
	public LeaveDetailVO save(LeaveDetailVO leaveDetailVO) {
		if (leaveDetailVO.getId() != null) {
			LeaveDetail leaveDetail = findById(leaveDetailVO.getId());
			LeaveDetailMapper.updateLeaveDetail(leaveDetailVO, leaveDetail);
			leaveDetail.setEmployee(findEmpById(leaveDetailVO.getEmployee()));
			entityManager.merge(leaveDetail);
			return LeaveDetailMapper.updateLeaveDetailVO(leaveDetail);
		} else {
			LeaveDetail leaveDetail = new LeaveDetail();
//			String employee_id = leaveDetailVO.getEmployee();
//			EmployeeVO empVO = employeeDao.findEmployeeByEmployeeId(employee_id);
//			Employee emp = new Employee();
//			emp = EmployeeMapper.updateEmployee(empVO, emp);
//			leaveDetail.setEmployee(emp);
			leaveDetail = LeaveDetailMapper.updateLeaveDetail(leaveDetailVO, leaveDetail);
			try {
				entityManager.persist(leaveDetail);
				return leaveDetailVO;
			} catch (Exception e) {
				System.out.println(e.toString());
				return null;
			}
		}

	}

	public Employee findEmpById(String id) {
		String hql = "select e from Employee e where id =:id";
		Employee employee = null;
		employee = (Employee) entityManager.createQuery(hql).setParameter("id", id).getSingleResult();
		return employee;
	}

}
