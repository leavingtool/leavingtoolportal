package com.dynagility.leavingtoolportal.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dynagility.leavingtoolportal.object_value.EmployeeVO;
import com.dynagility.leavingtoolportal.service.EmployeeService;
import com.dynagility.leavingtoolportal.service.MailService;

@RestController
public class EmployeeController extends BaseController {

    @Autowired
    private EmployeeService employeeService;
   
    @Autowired 
    private MailService mailService;

    public static final String SEND_MAIL = "/api/sendmail";

    public static final String BASE_URL_API = "/api/employee";
    public static final String GET_ALL_EMPLOYEE_URL_API = "/api/employees";
    public static final String GET_EMPLOYEE_DETAIL_BY_ID_API = "/{id}";
    public static final String UPDATE_EMPLOYEE_BY_ID = "/{id}";
    public static final String DELETE_EMPLOYEE_BY_ID = "/{id}";
    public static final String LOGIN = "/login"; 
    public static final String LOGOUT = "/logout"; 
    
    @RequestMapping(value = BASE_URL_API + LOGIN, method=RequestMethod.POST)
    public ResponseEntity<?> login() {

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value= BASE_URL_API + LOGOUT, method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "Logout success.";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }

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
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
