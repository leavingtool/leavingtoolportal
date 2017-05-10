package com.dynagility.leavingtoolportal.DaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dynagility.leavingtoolportal.Dao.ReasonDao;
import com.dynagility.leavingtoolportal.VO.AccountVO;
import com.dynagility.leavingtoolportal.VO.ReasonVO;
import com.dynagility.leavingtoolportal.model.Account;
import com.dynagility.leavingtoolportal.model.Reason;
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
	public ReasonVO getReasonByReasonId(String reason_id) {
    	String hql = "select re from Reason re where id =:reason_id";
        Reason reason = null;
        reason =  (Reason) entityManager.createQuery(hql).setParameter("reason_id", reason_id).getSingleResult();
        ReasonVO reasonVO = new ReasonVO(reason.getId(), reason.getName());
        return reasonVO;
	}

}
