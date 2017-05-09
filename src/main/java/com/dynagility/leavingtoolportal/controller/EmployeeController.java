package com.dynagility.leavingtoolportal.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dynagility.leavingtoolportal.VO.EmployeeVO;
import com.dynagility.leavingtoolportal.VO.LoginVO;
import com.dynagility.leavingtoolportal.model.Account;
import com.dynagility.leavingtoolportal.service.EmployeeService;
import com.dynagility.leavingtoolportal.service.LoginService;
import com.dynagility.leavingtoolportal.service.MailService;

@RestController
public class EmployeeController extends BaseController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private LoginService loginService;
    @Autowired 
    private MailService mailService;

    public static final String SEND_MAIL = "/api/sendmail";

    public static final String BASE_URL_API = "/api/employee";
    public static final String GET_ALL_EMPLOYEE_URL_API = "/api/employees";
    public static final String GET_EMPLOYEE_DETAIL_BY_ID_API = "/{id}";
    public static final String UPDATE_EMPLOYEE_BY_ID = "/{id}";
    public static final String DELETE_EMPLOYEE_BY_ID = "/{id}";
    public static final String CHECK_ACCOUNT = "/api/account";
    public static final String USER_DETAIL = "/api/employee/detail";

    //Add New Employee API
    @RequestMapping(value = BASE_URL_API, method=RequestMethod.POST)
    public ResponseEntity<?> addNewEmployee(@RequestBody EmployeeVO newEmployeeVO) {

        checkLogin();

        EmployeeVO employeeVO = employeeService.addEmployee(newEmployeeVO);

        return new ResponseEntity<>(employeeVO, HttpStatus.CREATED);
    }

    //Get All Employee API
    @RequestMapping(value = GET_ALL_EMPLOYEE_URL_API, method=RequestMethod.GET)
    public ResponseEntity<?> getAllEmployee() {

        checkLogin();

        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    //Get Employee Detail By Employee Id
    @RequestMapping(value = BASE_URL_API + GET_EMPLOYEE_DETAIL_BY_ID_API, method = RequestMethod.GET)
    public ResponseEntity<?> getEmployeeDetail(@PathVariable("id") String id) {

        checkLogin();

        EmployeeVO employeeDetail = employeeService.getEmployeeById(id);

        return new ResponseEntity<EmployeeVO>(employeeDetail, HttpStatus.OK);
    }

    //Delete Employee By Employee Id
    @RequestMapping(value = BASE_URL_API + DELETE_EMPLOYEE_BY_ID, method=RequestMethod.DELETE)
    public HttpEntity<?> deleteEmployee(@PathVariable("id") String id) {

        checkLogin();

        employeeService.deleteEmployeeById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Update Employee Info By Employee Id
    @RequestMapping(value = BASE_URL_API + UPDATE_EMPLOYEE_BY_ID, method=RequestMethod.PUT)
    public ResponseEntity<?> updateEmployee(@PathVariable("id") String id, @RequestBody EmployeeVO employeeVO) {

        checkLogin();

        employeeVO.setId(id);
        EmployeeVO updatedEmployee = employeeService.updateEmployee(employeeVO);

        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    //Send Mail API
    @RequestMapping (value = SEND_MAIL, method = RequestMethod.GET)
    public ResponseEntity<?> sendMail() throws IOException{
        mailService.sendMail();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    //Login API
    @CrossOrigin
    @RequestMapping(value = CHECK_ACCOUNT, method=RequestMethod.POST)
    public ResponseEntity<?> loginTest(@RequestBody Account account) {
        LoginVO _checkAcc = loginService.checkLogin(account);
        return new ResponseEntity<>(_checkAcc, HttpStatus.OK);
    }
    
    @CrossOrigin
    @RequestMapping(value = USER_DETAIL, method=RequestMethod.GET)
    public ResponseEntity<?> getUserDetail(@RequestParam("id") String id) {

    	checkLogin();
        EmployeeVO emp = employeeService.getEmployeeDetailById(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
}
