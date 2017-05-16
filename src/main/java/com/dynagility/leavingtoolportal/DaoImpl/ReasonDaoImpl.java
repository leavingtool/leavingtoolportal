package com.dynagility.leavingtoolportal.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dynagility.leavingtoolportal.Dao.ReasonDao;
import com.dynagility.leavingtoolportal.VO.AccountVO;
import com.dynagility.leavingtoolportal.VO.EmployeeVO;
import com.dynagility.leavingtoolportal.VO.ReasonVO;
import com.dynagility.leavingtoolportal.model.Account;
import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.model.Reason;
import com.dynagility.leavingtoolportal.model.mapper.EmployeeMapper;
import com.dynagility.leavingtoolportal.model.mapper.ReasonMapper;
import com.dynagility.leavingtoolportal.model.mapper.RoleMapper;
@Repository
@Transactional
public class ReasonDaoImpl implements ReasonDao{
	@PersistenceContext 
    private EntityManager entityManager;
	private ReasonMapper reasonMapper;
    @SuppressWarnings("unchecked")
	@Override
	public ReasonVO getReasonByReasonId(String reasonId) {
    	String hql = "select re from Reason re where id =:reason_id";
        Reason reason = null;
        reason =  (Reason) entityManager.createQuery(hql).setParameter("reason_id", reasonId).getSingleResult();
        ReasonVO reasonVO = new ReasonVO(reason.getId(), reason.getName());
        return reasonVO;
	}
	@Override
	public List<ReasonVO> getAllReason() {
		 String hql = "from Reason";
	        List<Reason> reasons = null;
	        reasons = entityManager.createQuery(hql).getResultList();
	        List<ReasonVO> reasonVOs = new ArrayList<ReasonVO>();
	        for(Reason r : reasons) {
	            reasonVOs.add(ReasonMapper.updateReasonVO(r));
	        }
	        return reasonVOs;
		
	}

}
