package com.dynagility.leavingtoolportal.service;

import java.util.ArrayList;
import java.util.List;

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
	
	public ReasonVO getReasonByReasonId(String reasonId) {
    	return reasonDao.getReasonByReasonId(reasonId);
    }
	public List<ReasonVO>getAllReason(){
		List<ReasonVO>list = reasonDao.getAllReason();
		return list;
	}
}
