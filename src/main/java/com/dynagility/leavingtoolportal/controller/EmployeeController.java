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
import org.springframework.web.bind.annotation.RestController;

import com.dynagility.leavingtoolportal.exceptions.NotFoundException;
import com.dynagility.leavingtoolportal.model.Account;
import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.service.EmployeeDetailVOService;
import com.dynagility.leavingtoolportal.service.EmployeeService;
import com.dynagility.leavingtoolportal.service.MailService;

@RestController
public class EmployeeController extends BaseController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired 
    private EmployeeDetailVOService employeeDetailService;
    @Autowired 
    private MailService mailService;

    public static final String SEND_MAIL = "/api/sendmail";

    public static final String BASE_URL_API = "/api/employee";
    public static final String GET_ALL_EMPLOYEE_URL_API = "/api/employees";
    public static final String GET_EMPLOYEE_DETAIL_BY_ID_API = "/{id}";
    public static final String UPDATE_EMPLOYEE_BY_ID = "/{id}";
    public static final String DELETE_EMPLOYEE_BY_ID = "/{id}";
    public static final String CHECK_ACCOUNT = "/api/account";

    //Add New Employee API
    @RequestMapping(value = BASE_URL_API, method=RequestMethod.POST)
    public ResponseEntity<?> addNewEmployee(@RequestBody Employee newEmployee) {

        checkLogin();

        Employee employee = employeeService.addEmployee(newEmployee);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
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

        Employee employeeDetail = employeeService.getEmployeeById(id);

        if (employeeDetail == null) {
            throw new NotFoundException("Employee is not there");
        }

        return new ResponseEntity<Employee>(employeeDetail, HttpStatus.OK);
    }

    //Delete Employee By Employee Id
    @RequestMapping(value = BASE_URL_API + DELETE_EMPLOYEE_BY_ID, method=RequestMethod.DELETE)
    public HttpEntity<?> deleteEmployee(@PathVariable("id") String id) {

        checkLogin();

        boolean employee = employeeService.deleteEmployeeById(id);

        if (employee == false) {
            throw new NotFoundException("Employee is not there");
        } 
        else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    //Update Employee Info By Employee Id
    @RequestMapping(value = BASE_URL_API + UPDATE_EMPLOYEE_BY_ID, method=RequestMethod.PUT)
    public ResponseEntity<?> updateEmployee(@PathVariable("id") String id, @RequestBody Employee employee) {

        checkLogin();

        employee.setId(id);
        Employee updateEmployee = employeeService.updateEmployee(employee);
        if (updateEmployee == null) {
            throw new NotFoundException("Employee is not there");
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //Send Mail API
    @RequestMapping (value = SEND_MAIL, method = RequestMethod.GET)
    public ResponseEntity<?> sendMail() throws IOException{
        mailService.sendMail();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

  //Login Test
    @CrossOrigin
    @RequestMapping(value = CHECK_ACCOUNT, method=RequestMethod.POST)
    public ResponseEntity<?> loginTest(@RequestBody Account account) {

        boolean _checkAcc = employeeService.checkLogin(account);
        
        if (_checkAcc == false) {
            throw new NotFoundException("Cannot Login");
        } 
        else {
        	
            return new ResponseEntity<>(employeeDetailService.getUserDetailByAccountName(account.getUsername()), HttpStatus.OK);
        }
    }
}
