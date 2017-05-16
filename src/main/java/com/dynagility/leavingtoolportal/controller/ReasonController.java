package com.dynagility.leavingtoolportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dynagility.leavingtoolportal.VO.ReasonVO;
import com.dynagility.leavingtoolportal.service.LeaveDetailService;
import com.dynagility.leavingtoolportal.service.ReasonService;
@RestController
public class ReasonController extends BaseController{
	public static final String ALL_REASON = "/api/reasons";
	@Autowired
    private ReasonService reasonService;
	
	@CrossOrigin
    @RequestMapping(value = ALL_REASON, method=RequestMethod.GET)
    public ResponseEntity<?> getLeaveDetail() {
        List<ReasonVO>list = reasonService.getAllReason();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
	
	
}
