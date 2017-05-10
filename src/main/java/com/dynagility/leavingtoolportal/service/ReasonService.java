package com.dynagility.leavingtoolportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynagility.leavingtoolportal.Dao.AccountDao;
import com.dynagility.leavingtoolportal.Dao.ReasonDao;
import com.dynagility.leavingtoolportal.VO.LoginVO;
import com.dynagility.leavingtoolportal.VO.ReasonVO;
import com.dynagility.leavingtoolportal.model.Account;

@Service
public class ReasonService {
	@Autowired
    private ReasonDao reasonDao;
	
	public ReasonVO getReasonByReasonId(String reason_id) {
    	return reasonDao.getReasonByReasonId(reason_id);
    }
}
