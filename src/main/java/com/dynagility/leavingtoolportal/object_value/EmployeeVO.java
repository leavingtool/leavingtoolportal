package com.dynagility.leavingtoolportal.object_value;

import java.io.Serializable;
import java.util.Date;

import com.dynagility.leavingtoolportal.model.Position;

public class EmployeeVO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
    private String name;
    private String email;
    private Integer balanceDay;
    private Integer deductedDay;
    private Position position;
    private Date joinDate;

    public EmployeeVO() {
    }

    public EmployeeVO(String id, String name, String email, Integer balanceDay,
            Integer deductedDay, Position position, Date joinDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.balanceDay = balanceDay;
        this.deductedDay = deductedDay;
        this.position = position;
        this.joinDate = joinDate;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
}
