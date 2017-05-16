package com.dynagility.leavingtoolportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dynagility.leavingtoolportal.VO.DateTimeLeaveVO;
import com.dynagility.leavingtoolportal.VO.EmployeeVO;
import com.dynagility.leavingtoolportal.VO.LeaveDetailVO;
import com.dynagility.leavingtoolportal.service.LeaveDetailService;
import com.dynagility.leavingtoolportal.service.LeaveReasonByYearService;

@RestController
public class LeaveDetailController extends BaseController{
    public static final String LEAVE_DETAIL = "/api/leavedetail";
    public static final String LEAVE_DETAIL_REASON_YEAR = "/api/leavedetail/reasonandyear";
    public static final String GET_DATE_TIME_CURRENT = "/api/current";
    public static final String NEW_LEAVE_DETAIL = "/api/newleavedetail";
	@Autowired
    private LeaveDetailService leaveDetailService;
	@Autowired
    private LeaveReasonByYearService leaveReasonByYearService;
	
	@CrossOrigin
    @RequestMapping(value = LEAVE_DETAIL, method=RequestMethod.GET)
    public ResponseEntity<?> getLeaveDetail(@RequestParam("id") String id) {
        Object obj = leaveDetailService.getLeaveDetailById(id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
	
	@CrossOrigin
    @RequestMapping(value = LEAVE_DETAIL_REASON_YEAR, method=RequestMethod.GET)
    public ResponseEntity<?> getLeaveDetailByReasonAndYear(@RequestParam("id") String employeeId) {
		Object obj = leaveReasonByYearService.getLeaveReasonByYear(employeeId);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
	
	
    @RequestMapping(value = GET_DATE_TIME_CURRENT, method=RequestMethod.GET)
    public ResponseEntity<?> getDateTimeCurrent() {
		
        return new ResponseEntity<>(leaveDetailService.formatDateTimeLeaveVO(), HttpStatus.OK);
    }
    
    @RequestMapping(value = NEW_LEAVE_DETAIL, method=RequestMethod.POST)
    public ResponseEntity<?> addNewLeaveDetail(@RequestBody LeaveDetailVO newLeaveVO) {

        

        LeaveDetailVO leaveDetailVO = leaveDetailService.addLeaveDetail(newLeaveVO);
        System.out.println("sssssssssssssssssssssssssssssppppppppppppppppp");

        return new ResponseEntity<>(leaveDetailVO, HttpStatus.OK);
    }
	
	
	
	
}
