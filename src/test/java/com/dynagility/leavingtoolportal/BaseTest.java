package com.dynagility.leavingtoolportal;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.security.SecurityUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ApplicationTests.class)
public abstract class BaseTest {
    protected TestRestTemplate restTemplate = new TestRestTemplate();

    @Autowired
    private JdbcTemplate jdbcTemplate;

//   @Autowired
//   protected EmployeeRepository employeeRepository;

    @MockBean protected SecurityUtil mockSecurityUtil;

    protected String host;

    @LocalServerPort 
    protected int port;

    public Employee employeeObj = null;

    public BaseTest() {
    	
    }

}
