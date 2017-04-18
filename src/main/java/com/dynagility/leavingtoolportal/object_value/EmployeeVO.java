package com.dynagility.leavingtoolportal.object_value;

import java.util.Date;

import com.dynagility.leavingtoolportal.model.Employee;

public class EmployeeVO {
    private String id;
    private String name;
    private String email;
    private Integer balanceDay;
    private Integer deductedDay;
    private String positionId;
    private Date joinDate;

    //Update Field In Model
    public void update(EmployeeVO source) {
        this.setName(source.getName() != null ? source.getName() : this.getName());
        this.setEmail(source.getEmail() != null ? source.getEmail() : this.getEmail());
        this.setBalanceDay(source.getBalanceDay() != null ? source.getBalanceDay() : this.getBalanceDay());
        this.setDeductedDay(source.getDeductedDay() != null ? source.getDeductedDay() : this.getDeductedDay());
        this.setPositionId(source.getPositionId() != null ? source.getPositionId() : this.getPositionId());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getBalanceDay() {
        return balanceDay;
    }

    public void setBalanceDay(Integer balanceDay) {
        this.balanceDay = balanceDay;
    }

    public Integer getDeductedDay() {
        return deductedDay;
    }

    public void setDeductedDay(Integer deductedDay) {
        this.deductedDay = deductedDay;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
}
