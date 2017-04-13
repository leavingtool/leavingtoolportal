package com.dynagility.leavingtoolportal.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import com.dynagility.leavingtoolportal.util.CustomDateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name = "employee")
@DynamicUpdate
public class Employee {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "balance_day", nullable = true)
    private Integer balanceDay;

    @Column(name = "deducted_day", nullable = true)
    private Integer deductedDay;

    @Column(name = "position_id", nullable = true)
    private String positionId;

    @JsonFormat(pattern = CustomDateDeserializer.DATE_PATTERN)
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @Column(name = "join_date", nullable = true)
    private Date joinDate;

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