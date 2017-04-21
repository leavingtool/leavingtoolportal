package com.dynagility.leavingtoolportal.schedules;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dynagility.leavingtoolportal.Dao.EmployeeDao;
import com.dynagility.leavingtoolportal.object_value.EmployeeVO;

@Component
public class ScheduleTasks {
    @Autowired
    EmployeeDao employeeDao;
    @Scheduled(cron = "0 0 0 15 * ?")
    public void scheduleTasks() {
        List<EmployeeVO> employeeVOs = employeeDao.findAll();
        for(EmployeeVO e : employeeVOs) {
            e.setBalanceDay(e.getBalanceDay()+1);
            employeeDao.save(e);
        }
    }
}
